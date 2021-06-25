package com.example.code4covid_404notfound;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;


public class QuizeFragment extends Fragment {



//    public QuizeFragment() {
//        // Required empty public constructor
//    }



    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore = 0,questionAttempted = 1,currentPos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        View v = inflater.inflate(R.layout.fragment_quize,container,false);
        questionTV = v.findViewById(R.id.idTVQuestion);
        questionNumberTV =v.findViewById(R.id.idTVQuestionsAttempted);
        option1Btn = v.findViewById(R.id.idBtnOption1);
        option2Btn = v.findViewById(R.id.idBtnOption2);
        option3Btn = v.findViewById(R.id.idBtnOption3);
        option4Btn = v.findViewById(R.id.idBtnOption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToView(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });
        return v;
    }

    private void showBottomSheet(){
        LinearLayout linearLayout = new LinearLayout(getActivity());

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
        View bottomSheetView;
        bottomSheetView = LayoutInflater.from(getContext()).inflate(R.layout.score_bottom_sheet,linearLayout.findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizeBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score Is \n"+currentScore+"/6");
        restartQuizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionAttempted = 0;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToView(int currentPos) {
        questionNumberTV.setText("Questions Attempted: " + questionAttempted + "/6");
        if (questionAttempted == 6) {
            showBottomSheet();
        } else {
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuestion(ArrayList<QuizModel> quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("How Are Your Feeling Today?","GREAT","GOOD","NOT WELL","WORST","GREAT"));
        quizModelArrayList.add(new QuizModel("Do you Have Cold Today?","Yes","No","Mild","severe","No"));
        quizModelArrayList.add(new QuizModel("Do you Have Cough Today?","Yes","No","Mild","severe","No"));
        quizModelArrayList.add(new QuizModel("Do you Have Fever Today?","Yes","No","Mild","severe","No"));
        quizModelArrayList.add(new QuizModel("Do you Have Body Pains Today?","Yes","No","Mild","severe","No"));
        quizModelArrayList.add(new QuizModel("Do you Have Breathing problem Today?","Yes","No","Mild","severe","No"));

    }
}