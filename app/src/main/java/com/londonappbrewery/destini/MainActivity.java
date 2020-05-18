package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTopButton;
    Button mBottomButton;
    int mStoryIndex=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null) {
            mStoryIndex = savedInstanceState.getInt("StoryKey");
        } else {
            mStoryIndex = 1;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);

        switch(mStoryIndex) {
            case 1:
                mStoryTextView.setText(R.string.T1_Story);
                mTopButton.setText(R.string.T1_Ans1);
                mBottomButton.setText(R.string.T1_Ans2);
                break;
            case 2:
                mStoryTextView.setText(R.string.T2_Story);
                mTopButton.setText(R.string.T2_Ans1);
                mBottomButton.setText(R.string.T2_Ans2);
                break;
            case 3:
                mStoryTextView.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
                break;
            case 4:
                mStoryTextView.setText(R.string.T4_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
                break;
            case 5:
                mStoryTextView.setText(R.string.T5_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
                break;
            case 6:
                mStoryTextView.setText(R.string.T6_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
                break;

        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mStoryIndex==1 || mStoryIndex == 2) {
                    mStoryTextView.setText(R.string.T3_Story);
                    mTopButton.setText(R.string.T3_Ans1);
                    mBottomButton.setText(R.string.T3_Ans2);
                    mStoryIndex = 3;
                } else if(mStoryIndex == 3) {
                    mStoryTextView.setText(R.string.T6_End);
                    mTopButton.setVisibility(View.INVISIBLE);
                    mBottomButton.setVisibility(View.INVISIBLE);
                    mStoryIndex = 6;
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex == 1) {
                    mStoryTextView.setText(R.string.T2_Story);
                    mTopButton.setText(R.string.T2_Ans1);
                    mBottomButton.setText(R.string.T2_Ans2);
                    mStoryIndex = 2;
                } else if(mStoryIndex == 3) {
                    mStoryTextView.setText(R.string.T5_End);
                    mTopButton.setVisibility(View.INVISIBLE);
                    mBottomButton.setVisibility(View.INVISIBLE);
                    mStoryIndex = 5;
                } else if(mStoryIndex == 2) {
                    mStoryTextView.setText(R.string.T4_End);
                    mTopButton.setVisibility(View.INVISIBLE);
                    mBottomButton.setVisibility(View.INVISIBLE);
                    mStoryIndex = 4;
                }

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryKey", mStoryIndex);
    }

}
