package uottawa.engineering.rentcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText rent, numOfRooms;

    Button chooseRooms;

    public int amountOfRooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rent = findViewById(R.id.rentText);
        rent.addTextChangedListener(textWatcher);

        numOfRooms = findViewById(R.id.numOfRoomsText);
        numOfRooms.addTextChangedListener(textWatcher);

        chooseRooms = findViewById(R.id.chooseRoomButton);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        public void afterTextChanged(Editable s) {
            if(rent.getText().toString().length() > 0 && Float.parseFloat(rent.getText().toString()) > 0
                    && numOfRooms.getText().toString().length() > 0 && Integer.parseInt(numOfRooms.getText().toString()) > 0){
                chooseRooms.setEnabled(true);
            }
            else{
                chooseRooms.setEnabled(false);

                //error
                if(rent.getText().toString().length() == 0){
                    //enable error
                    //set error to rent cannot be empty
                }
                else if(Float.parseFloat(rent.getText().toString()) == 0) {
                    //enable error
                    //set error to rent cannot be 0
                }
                else{
                    //disable error
                }

                if(numOfRooms.getText().toString().length() == 0){
                    //enable error
                    //set error to Number of Rooms cannot be empty
                }
                else if(Integer.parseInt(numOfRooms.getText().toString()) == 0) {
                    //enable error
                    //set error to Number of rooms cannot be 0
                }
                else{
                    //disable error
                }
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        public void onTextChanged(CharSequence s, int start, int before, int count) {}
    };

    public void ChangePage(View v){
        amountOfRooms = Integer.parseInt(numOfRooms.getText().toString());
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }


}
