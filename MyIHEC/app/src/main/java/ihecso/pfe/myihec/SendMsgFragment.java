package ihecso.pfe.myihec;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SendMsgFragment extends Fragment {

    private SendMsgViewModel mViewModel;
    private EditText mEditTextto;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;

    public static SendMsgFragment newInstance() {
        return new SendMsgFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.send_msg_fragment, container, false);
        mEditTextto = root.findViewById(R.id.edit_text_to1);
        mEditTextSubject = root.findViewById(R.id.edit_text_subject1);
        mEditTextMessage = root.findViewById(R.id.edit_text_message1);
        Button buttonSend = root.findViewById(R.id.btn_envoyer1);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();

            }
        });
        return root;
    }

    public void sendMail(){
        String recipientList = mEditTextto.getText().toString();
        String[] recipients = recipientList.split(",");
        //example1@gmail.com,example2@gmail.com
        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        //intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Envoyer par"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SendMsgViewModel.class);
        // TODO: Use the ViewModel
    }

}