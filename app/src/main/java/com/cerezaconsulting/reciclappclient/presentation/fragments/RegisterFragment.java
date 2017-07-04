package com.cerezaconsulting.reciclappclient.presentation.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseActivity;
import com.cerezaconsulting.reciclappclient.core.BaseFragment;
import com.cerezaconsulting.reciclappclient.data.entities.UserEntity;
import com.cerezaconsulting.reciclappclient.presentation.contracts.RegisterContract;
import com.cerezaconsulting.reciclappclient.presentation.utils.ProgressDialogCustom;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * Created by miguel on 16/05/17.
 */

public class RegisterFragment extends BaseFragment implements RegisterContract.View, Validator.ValidationListener, DatePickerDialog.OnDateSetListener {

    private static int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    @NotEmpty(message = "Este campo no puede ser vacío")
    @BindView(R.id.et_first_name)
    EditText etFirstName;
    @NotEmpty(message = "Este campo no puede ser vacío")
    @BindView(R.id.et_last_name)
    EditText etLastName;
    @NotEmpty(message = "Este campo no puede ser vacío")
    @BindView(R.id.et_dni)
    EditText etDni;
    @NotEmpty(message = "Este campo no puede ser vacío")
    @BindView(R.id.et_birth_date)
    EditText etBirthDate;
    @Email(message = "Este campo no tiene el formato email")
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_user)
    EditText etUser;
    @Password(message = "La contraseña debe tener mínimo 6 campos")
    @BindView(R.id.et_password)
    EditText etPassword;
    @ConfirmPassword(message = "No concuerda con la contraseña")
    @BindView(R.id.et_repeat_password)
    EditText etRepeatPassword;
    @BindView(R.id.btn_register)
    Button btnRegister;
    Unbinder unbinder;
    @NotEmpty(message = "Este campo no puede ser vacío")
    @BindView(R.id.et_district)
    EditText etDistrict;

    private DatePickerDialog dpd;
    private boolean enableIntent = true;
    private ProgressDialogCustom mProgressDialogCustom;
    private RegisterContract.Presenter presenter;
    private String district = "";
    private Validator validator;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        validator = new Validator(this);
        validator.setValidationListener(this);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(),"Registrando...");
        Calendar now = Calendar.getInstance();
        dpd = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
    }

    @Override
    public void onResume() {
        super.onResume();
        enableIntent = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        validator.validate();
    }

    @Override
    public void registerSuccessfully() {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setTitle("Registro exitoso")
                .setMessage("Se ha registrado con éxito")
                .setPositiveButton("Aceptar",null)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        getActivity().finish();
                    }
                })
                .create();
        alertDialog.show();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if(mProgressDialogCustom!=null){
            if(active){
                mProgressDialogCustom.show();
            }
            else{
                mProgressDialogCustom.dismiss();
            }
        }
    }

    @Override
    public void setMessageError(String error) {
        ((BaseActivity)getActivity()).showMessageError(error);
    }

    @Override
    public void setDialogMessage(String message) {
        ((BaseActivity)getActivity()).showMessage(message);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @OnClick(R.id.et_district)
    public void onClicked() {
        initPlaceIntent();
    }

    private void initPlaceIntent() {
        if (enableIntent) {
            enableIntent = false;
            try {
                AutocompleteFilter autocompleteFilter = new AutocompleteFilter.Builder()
                        .setCountry("PE")
                        .setTypeFilter(AutocompleteFilter.TYPE_FILTER_NONE)
                        .build();
                Intent intent =
                        new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                                .setFilter(autocompleteFilter)
                                .build(getActivity());
                startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
            } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
                // TODO: Handle the error.
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(getActivity(), data);
                etDistrict.setText(place.getAddress());
                district = place.getName().toString();
            }
        }
    }

    @Override
    public void onValidationSucceeded() {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirst_name(etFirstName.getText().toString());
        userEntity.setLast_name(etLastName.getText().toString());
        userEntity.setEmail(etEmail.getText().toString());
        userEntity.setBirth_date(etBirthDate.getText().toString());
        userEntity.setDirection(etDistrict.getText().toString());
        userEntity.setDistrict(district);
        userEntity.setDni(etDni.getText().toString());
        userEntity.setPassword(etPassword.getText().toString());
        presenter.registerUser(userEntity);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());
            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else if (view instanceof TextView) {
                ((TextView) view).setError(message);
            } else {
                setMessageError(message);
            }
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        etBirthDate.setText(year + "-" + String.format("%02d", monthOfYear + 1) + "-" + String.format("%02d", dayOfMonth));
    }

    @OnClick(R.id.et_birth_date)
    public void onViewClickedDate() {
        dpd.show(getActivity().getFragmentManager(), "DatePickerDialog");
    }
}
