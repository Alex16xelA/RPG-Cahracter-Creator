package pl.wroc.pwr.a236139.rpgcharactercreator;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFragment extends Fragment implements View.OnClickListener {

    private TextView createOccupation;
    private TextView ageNumber,eyeColor,weight,hairColor, height, numberSiblings,starSign,birth;
    private Button rollDiceS, createButton, ww,k,us,odp,zr,intel,sw,ogd,a, zyw,s,wt,sz,mag,po,pp;
    private Dice dice1;
    private Character create;
    private History history;
    private HistoryORM h = new HistoryORM();;
    private String historyMessage;

    public CreateFragment() {
        // Required empty public constructor
        create= new Elf();
        historyMessage = " AAA ";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create, container, false);

        dice1 = new Dice(60);

        Spinner spinner = (Spinner) view.findViewById(R.id.race_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(),R.layout.costum_spinner,getResources().getStringArray(R.array.Race));
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               switch(position){
                   case 0:
                       create= new Elf();
                       break;
                   case 1:
                       create= new Human();
                       break;
                   case 2:
                       create= new Dwar();
                       break;
                   case 3:
                       create= new Halfling();
                       break;
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {
               create= new Elf();
           }
       });


    createOccupation = view.findViewById(R.id.create_occupation);

        ageNumber = view.findViewById(R.id.age_number);
        eyeColor = view.findViewById(R.id.eye_color);
        weight = view.findViewById(R.id.weight);
        hairColor = view.findViewById(R.id.hair_color);
        height = view.findViewById(R.id.height);
        numberSiblings = view.findViewById(R.id.number_siblings);
        starSign = view.findViewById(R.id.star_sign);
        birth = view.findViewById(R.id.place_of_birth);

        ww = view.findViewById(R.id.ww);
        us = view.findViewById(R.id.us);
        k = view.findViewById(R.id.k);
        odp = view.findViewById(R.id.odp);
        zr = view.findViewById(R.id.zr);
        intel = view.findViewById(R.id.intel);
        sw = view.findViewById(R.id.sw);
        ogd = view.findViewById(R.id.ogd);
        a = view.findViewById(R.id.a);
        zyw = view.findViewById(R.id.zyw);
        s = view.findViewById(R.id.s);
        wt = view.findViewById(R.id.wt);
        sz = view.findViewById(R.id.sz);
        mag = view.findViewById(R.id.mag);
        po = view.findViewById(R.id.po);
        pp = view.findViewById(R.id.pp);

        rollDiceS = view.findViewById(R.id.rollDiceSign);
        rollDiceS.setOnClickListener(this);

        createButton = view.findViewById(R.id.create_button);
        createButton.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
        }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.rollDiceSign:
            {
                createOccupation.setText("   "+cheackProfession(dice1.roll()));
                historyMessage = (String) createOccupation.getText();

                create.setStatsArray();
                create.setInfoArray();

                ageNumber.setText(create.getInfoArray(0));
                eyeColor.setText(create.getInfoArray(1));
                weight.setText(create.getInfoArray(2));
                hairColor.setText(create.getInfoArray(3));
                height.setText(create.getInfoArray(4));
                numberSiblings.setText(create.getInfoArray(5));
                starSign.setText(create.getInfoArray(6));
                birth.setText(create.getInfoArray(7));


                ww.setText(""+create.getStatsArray(0));
                us.setText(""+create.getStatsArray(1));
                k.setText(""+create.getStatsArray(2));
                odp.setText(""+create.getStatsArray(3));
                zr.setText(""+create.getStatsArray(4));
                intel.setText(""+create.getStatsArray(5));
                sw.setText(""+create.getStatsArray(6));
                ogd.setText(""+create.getStatsArray(7));

                a.setText(""+create.getStatsArray(8));
                zyw.setText(""+create.getStatsArray(9));
                s.setText(""+create.getStatsArray(10));
                wt.setText(""+create.getStatsArray(11));
                sz.setText(""+create.getStatsArray(12));
                mag.setText(""+create.getStatsArray(13));
                po.setText(""+create.getStatsArray(14));
                pp.setText(""+create.getStatsArray(15));

                break;
            }

            case R.id.create_button:
            {
                history = new History();
                String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                history.setContext(historyMessage);
                history.setDate(mydate);
                h.add(getActivity().getApplicationContext(), history);
                Toast.makeText(getActivity().getApplicationContext(), "You create your own character", Toast.LENGTH_LONG).show();
            }
        }
    }

    public String cheackProfession(int pomA){

            switch (pomA){
                case 1: return "Agitator";
                case 2: return "Apprentice Wizard";
                case 3: return "Bailiff";
                case 4: return "Barber-Surgeon";
                case 5: return "Boatman";
                case 6: return "Bodyguard";
                case 7: return "Bone Picker";
                case 8: return "Bounty Hunter";
                case 9: return "Burgher ";
                case 10: return "Camp Follower";
                case 11: return "Charcoal-Burner";
                case 12: return "Coachman";
                case 13: return "Entertainer";
                case 14: return "Envoy";
                case 15: return "Estalian Diestro";
                case 16: return "Ferryman";
                case 17: return "Fieldwarden";
                case 18: return "Fisherman";
                case 19: return "Grave Robber";
                case 20: return "Hedge Wizard ";
                case 21: return "Hunter";
                case 22: return "Initiate";
                case 23: return "Jailer";
                case 24: return "Kislevite Kossar";
                case 25: return "Kithband Warrior";
                case 26: return "Marine ";
                case 27: return "Mercenary ";
                case 28: return "Messenger";
                case 29: return "Militiaman";
                case 30: return "Miner";
                case 31: return "Noble";
                case 32: return "Norse Berserker";
                case 33: return "Servant";
                case 34: return "Outlaw";
                case 35: return "Outrider ";
                case 36: return "Peasant ";
                case 37: return "Pit Fighte";
                case 38: return "Protagonist ";
                case 39: return "Rat Catcher";
                case 40: return "Roadwarden";
                case 41: return "Rogue ";
                case 42: return "Runebearer ";
                case 43: return "Scribe";
                case 44: return "Seaman";
                case 45: return "Shieldbreaker ";
                case 46: return "Smuggler";
                case 47: return "Soldier";
                case 48: return "Squire";
                case 49: return "Student";
                case 50: return "Thief";
                case 51: return "Thug";
                case 52: return "Toll Keeper";
                case 53: return "Tomb Robber";
                case 54: return "Tradesman";
                case 55: return "Troll Slayer";
                case 56: return "Vagabond";
                case 57: return "Valet";
                case 58: return "Watchman";
                case 59: return "Woodsman";
                case 60: return "Zealot";
                default: return "Miner";
            }
        }
}

