package com.example.newnavigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SecondActivity extends BaseActivity {

    private RecyclerView chatsRV;
    private EditText userMsgEdt;
    private FloatingActionButton sendMsgFab;
    private final String USER_KEY = "user";
    private final String BOT_KEY = "bot";
    private RequestQueue mRequestQueue;
    private ArrayList<ChatsModal> chatsModalArrayList;
    private ChatRVAdapter chatRVAdapter;
    private Button b1, b2, b3, b4, b5, b6, b7, b8;
    private String mainEmotion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_second, null, false);
        drawer.addView(contentView, 0);
        navigationView.setCheckedItem(R.id.nav_activity2);
        fab.hide();

        chatsRV = findViewById(R.id.idRVChats);
        sendMsgFab = findViewById(R.id.idFABSend);
        userMsgEdt = findViewById(R.id.idEdtMessage);

        sendMsgFab.setVisibility(View.GONE);
        userMsgEdt.setVisibility(View.GONE);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);

        //below line is to initialize our request queue.
        mRequestQueue = Volley.newRequestQueue(SecondActivity.this);
        mRequestQueue.getCache().clear();
        chatsModalArrayList = new ArrayList<>();
        chatRVAdapter = new ChatRVAdapter(chatsModalArrayList, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        chatsRV.setLayoutManager(manager);
        chatsRV.setAdapter(chatRVAdapter);

        String welcome = "Hello User. How are you feeling today?";
        chatsModalArrayList.add(new ChatsModal(welcome,BOT_KEY));
        chatRVAdapter.notifyDataSetChanged();

        buttonDefinition();
        b7.setVisibility(View.GONE);
        b8.setVisibility(View.GONE);
    }


    public void buttonDefinition() {
        findViewById(R.id.button1).setOnClickListener(buttonClickListener);
        findViewById(R.id.button2).setOnClickListener(buttonClickListener);
        findViewById(R.id.button3).setOnClickListener(buttonClickListener);
        findViewById(R.id.button4).setOnClickListener(buttonClickListener);
        findViewById(R.id.button5).setOnClickListener(buttonClickListener);
        findViewById(R.id.button6).setOnClickListener(buttonClickListener);
        findViewById(R.id.button7).setOnClickListener(buttonClickListener);
        findViewById(R.id.button8).setOnClickListener(buttonClickListener);
    }

    private void setTextIfNotNull(Button b, String buttonText){
        if(buttonText!=null)
            b.setText(buttonText);
    }

    private void setButtonText(String buttonText1, String buttonText2, String buttonText3, String buttonText4){
        setTextIfNotNull(b1, buttonText1);
        setTextIfNotNull(b2, buttonText2);
        setTextIfNotNull(b3, buttonText3);
        setTextIfNotNull(b4, buttonText4);
    }

    private void setButtonState(){
        b5.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);
        b7.setVisibility(View.VISIBLE);
        b8.setVisibility(View.VISIBLE);
    }

    private void temp(String emotion, String buttonText1, String buttonText2, String buttonText3, String buttonText4){
        mainEmotion = emotion;
        getResponse(emotion);
        setButtonText(buttonText1,buttonText2,buttonText3,buttonText4);
        setButtonState();
    }
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button1:
                    if(mainEmotion=="")
                        temp("Sad","Family Pressure","Academic Pressure","Grief","Loneliness");
                    else{
                        switch(mainEmotion)
                        {
                            case "Sad":
                                getResponse("Family Pressure");
                                break;
                            case "Happy":
                                getResponse("Excitement");
                                break;
                            case "Angry":
                                getResponse("Hostility");
                                break;
                            case "Fear":
                                getResponse("Abused");
                                break;
                            case "Disgust":
                                getResponse("Feeling gross");
                                break;
                            case "Anxious":
                                getResponse("Embarrassed");
                                break;
                        }
                    }
                    break;
                case R.id.button2:
                    if(mainEmotion=="")
                    {
                        temp("Happy","Excitement","Relief",null,null);
                        b3.setVisibility(View.GONE);
                        b4.setVisibility(View.GONE);

                    }
                    else{
                        switch(mainEmotion)
                        {
                            case "Sad":
                                getResponse("Academic Pressure");
                                break;
                            case "Happy":
                                getResponse("Relief");
                                break;
                            case "Angry":
                                getResponse("Frustration");
                                break;
                            case "Fear":
                                getResponse("Violented");
                                break;
                            case "Disgust":
                                getResponse("Disapproval");
                                break;
                            case "Anxious":
                                getResponse("Ashamed");
                                break;
                        }
                    }
                    break;
                case R.id.button3:
                    if(mainEmotion=="")
                        temp("Angry","Hostility","Frustration","Jealous","Aggression");
                    else{
                        switch(mainEmotion)
                        {
                            case "Sad":
                                getResponse("Grief");
                                break;
                            case "Happy":
                                break;
                            case "Angry":
                                getResponse("Jealous");
                                break;
                            case "Fear":
                                getResponse("Scared");
                                break;
                            case "Disgust":
                                getResponse("Distaste");
                                break;
                            case "Anxious":
                                getResponse("Stressed");
                                break;
                        }
                    }
                    break;
                case R.id.button4:
                    if(mainEmotion=="")
                        temp("Fear","Abused","Violented","Scared","Worried");
                    else{
                        switch(mainEmotion)
                        {
                            case "Sad":
                                getResponse("Loneliness");
                                break;
                            case "Happy":
                                break;
                            case "Angry":
                                getResponse("Aggression");
                                break;
                            case "Fear":
                                getResponse("Worried");
                                break;
                            case "Disgust":
                                getResponse("Awkward");
                                break;
                            case "Anxious":
                                getResponse("Depressed");
                                break;
                        }
                    }
                    break;
                case R.id.button5:
                    if(mainEmotion=="")
                        temp("Disgust","Feeling gross","Disapproval","Distaste","Awkward");
                    else{
                        switch(mainEmotion)
                        {
                            case "Sad":
                                break;
                            case "Happy":
                                break;
                            case "Angry":
                                break;
                            case "Fear":
                                break;
                            case "Disgust":
                                break;
                            case "Anxious":
                                break;
                        }
                    }
                    break;
                case R.id.button6:
                    if(mainEmotion=="")
                        temp("Anxious","Embarrassed","Ashamed","Stressed","Depressed");
                    else{
                        switch(mainEmotion)
                        {
                            case "Sad":
                                break;
                            case "Happy":
                                break;
                            case "Angry":
                                break;
                            case "Fear":
                                break;
                            case "Disgust":
                                break;
                            case "Anxious":
                                break;
                        }
                    }
                    break;
                case R.id.button7:
                    Others();
                    break;
                case R.id.button8:
                    getResponse(b8.getText().toString());
                    break;
            }
        }
    };

    private void getResponse(String message){


        chatsModalArrayList.add(new ChatsModal(message,USER_KEY));
        chatRVAdapter.notifyDataSetChanged();

        if(message.equals("Bye!👋")){
            message = (String) "Bye!";
            //Toast.makeText(SecondActivity.this, ""+message, Toast.LENGTH_SHORT).show();
        }

        String url = "http://api.brainshop.ai/get?bid=161192&key=eREue5fyn97d8YZV&uid=[uid]&msg="+message;
        String BASE_URL = "http://api.brainshop.ai/";
//        Toast.makeText(MainActivity.this, ""+message, Toast.LENGTH_SHORT).show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<MsgModel> call = retrofitAPI.getmessage(url);
        call.enqueue(new Callback<MsgModel>() {
            @Override
            public void onResponse(Call<MsgModel> call, Response<MsgModel> response) {
                if (response.isSuccessful()){
                    MsgModel modal = response.body();
                    chatsModalArrayList.add(new ChatsModal(modal.getCnt(),BOT_KEY));
                    chatRVAdapter.notifyDataSetChanged();
                    chatsRV.smoothScrollToPosition(chatsRV.getAdapter().getItemCount());
                    //Toast.makeText(SecondActivity.this, modal.getCnt(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MsgModel> call, Throwable t) {
                chatsModalArrayList.add(new ChatsModal("Please Revert your Question",BOT_KEY));
                chatRVAdapter.notifyDataSetChanged();
                //Toast.makeText(SecondActivity.this, t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void Others(){
        sendMsgFab.setVisibility(View.VISIBLE);
        userMsgEdt.setVisibility(View.VISIBLE);

        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        b3.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        b5.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);
        b7.setVisibility(View.GONE);

        sendMsgFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userMsgEdt.getText().toString().isEmpty()){
                    Toast.makeText(SecondActivity.this, "Please enter your message",Toast.LENGTH_SHORT).show();
                    return;
                }
                getResponse(userMsgEdt.getText().toString());
                userMsgEdt.setText("");
            }
        });
    }
}