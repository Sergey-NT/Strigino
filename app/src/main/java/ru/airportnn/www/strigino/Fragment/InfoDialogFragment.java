package ru.airportnn.www.strigino.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;

import ru.airportnn.www.strigino.Constants;
import ru.airportnn.www.strigino.R;

public class InfoDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final SharedPreferences settings = requireActivity().getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(getString(R.string.dialog_title))
                .setMessage(getString(R.string.dialog_message))
                .setNegativeButton(getString(R.string.dialog_button_negative), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putBoolean(Constants.APP_PREFERENCES_SHOW_DIALOG, false);
                        editor.apply();

                        dialog.cancel();
                    }
                })
                .setPositiveButton(getString(R.string.dialog_button_positive), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putBoolean(Constants.APP_PREFERENCES_SHOW_DIALOG, true);
                        editor.apply();

                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}