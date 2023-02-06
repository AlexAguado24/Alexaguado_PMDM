package com.example.iniciofragments.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        builder.setMessage("Primera app con fragments")
        builder.setPositiveButton("Ok"){_,_->}
        return builder.create()
    }
}