package ru.airportnn.www.strigino.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import ru.airportnn.www.strigino.Constants;
import ru.airportnn.www.strigino.R;


public class UpdateDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.dialog_title_new_version))
                .setMessage(getString(R.string.dialog_message_new_version))
                .setNegativeButton(getString(R.string.dialog_button_negative_update), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences settings = getActivity().getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putBoolean(Constants.APP_PREFERENCES_CANCEL_CHECK_VERSION, true);
                        editor.apply();

                        dialog.cancel();
                        getActivity().finish();
                    }
                })
                .setPositiveButton(getString(R.string.dialog_button_positive_update), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("market://details?id=ru.koltsovo.www.koltsovo"));
                        startActivity(intent);

                        dialog.cancel();
                        getActivity().finish();
                    }
                });

        return builder.create();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        getActivity().finish();
    }
}
