package com.example.saurabhsinghrajput.rockpaperscissor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by SAURABH SINGH RAJPUT on 17-09-2016.
 */
public class democlass extends AppCompatActivity {
    int i,GameValue;
    Random r;
    Button rock,paper,scissor;
    ImageView sysimage,myimage;
    TextView sysscore,myscore,gametimer,timer2,alert,alert_msg;
    int m_score,s_score;


    @Override

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        r=new Random();
        rock=(Button)findViewById(R.id.rock);
        paper=(Button)findViewById(R.id.paper);
        scissor=(Button)findViewById(R.id.scissor);

        sysimage=(ImageView)findViewById(R.id.sysimage);
        myimage=(ImageView)findViewById(R.id.myimage);

        sysscore=(TextView)findViewById(R.id.system_score);
        myscore=(TextView)findViewById(R.id.myscore) ;
        gametimer=(TextView)findViewById(R.id.game_timer);
        timer2=(TextView)findViewById(R.id.timer2);
        alert=(TextView)findViewById(R.id.alert_title);
        alert_msg=(TextView)findViewById(R.id.message_alert_dialog);




        gameplay();
        countdown cnt=new countdown(60000,1000);
        cnt.start();

    }

    private void gameplay() {
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myimage.setImageResource(R.drawable.rock);
                GameValue=rndm();
                if(GameValue==0)
                {
                    Toast.makeText(democlass.this,"It's Tie", Toast.LENGTH_SHORT).show();
                }
                else if(GameValue==1)
                {
                    Toast.makeText(democlass.this,"You Lose", Toast.LENGTH_SHORT).show();
                    s_score++;
                    sysscore.setText(String.valueOf(s_score));
                }


                else if(GameValue==2)
                {
                    Toast.makeText(democlass.this,"You Won", Toast.LENGTH_SHORT).show();
                    m_score++;
                    myscore.setText(String.valueOf(m_score));
                }



            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myimage.setImageResource(R.drawable.paper);
                GameValue=rndm();
                if(GameValue==1)
                {
                    Toast.makeText(democlass.this,"It's Tie", Toast.LENGTH_SHORT).show();
                }
                        else if(GameValue==0)
                {
                    Toast.makeText(democlass.this,"You Won", Toast.LENGTH_SHORT).show();
                    m_score++;
                    myscore.setText(String.valueOf(m_score));

                }
                else if(GameValue==2) {
                    Toast.makeText(democlass.this, "You Lose", Toast.LENGTH_SHORT).show();
                    s_score++;
                    sysscore.setText(String.valueOf(s_score));

                }


            }
        });

        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myimage.setImageResource(R.drawable.scissor);
                GameValue=rndm();
                if(GameValue==2)
                {
                    Toast.makeText(democlass.this,"It's Tie", Toast.LENGTH_SHORT).show();
                }
                else if(GameValue==1)
                {
                    Toast.makeText(democlass.this,"You Won", Toast.LENGTH_SHORT).show();
                    m_score++;
                    myscore.setText(String.valueOf(m_score));

                }
                else if(GameValue==0)
                {
                    Toast.makeText(democlass.this,"You Lose", Toast.LENGTH_SHORT).show();
                    s_score++;
                    sysscore.setText(String.valueOf(s_score));

                }



            }
        });



    }


    public class countdown extends CountDownTimer
    {

        public countdown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            long mills=l;
            String hms=String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(mills),
                       TimeUnit.MILLISECONDS.toMinutes(mills) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(mills)),
                       TimeUnit.MILLISECONDS.toSeconds(mills) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mills))
            );
            gametimer.setText(hms);
            timer2.setText(hms);

        }

        @Override
        public void onFinish() {
            //View v= LayoutInflater.from(democlass.this).inflate(R.layout.custom_alert,null);
                        AlertDialog.Builder builder=new AlertDialog.Builder(democlass.this);
                        //builder.setView(v);
                        builder.setTitle(Html.fromHtml("<font color='#814281'>Score</font>"));

                        builder.setCancelable(false);
                        StringBuffer buffer=new StringBuffer();

                        if(s_score>m_score)
                        {
                            buffer.append("System Won       \n");
                            buffer.append("System Score: "+s_score+".\n");
                            buffer.append("Your Score: "+m_score+".");
                            builder.setMessage(buffer);
                            //alert_msg.setText(buffer);
                        }
                        else if(s_score<m_score)
                        {
                            buffer.append("You Won      \n");
                            buffer.append("Your Score: "+m_score+".\n");
                            buffer.append("System Score: "+s_score+".\n");
                            builder.setMessage(buffer);
                           // alert_msg.setText(buffer);
                        }
                        else
                        {
                            buffer.append("It's Tie \n");
                           builder.setMessage(buffer);
                           // alert_msg.setText(buffer);
                        }
                        builder.setPositiveButton("Replay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                startActivity(getIntent());
                            }
                        });

                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                               // finish();
                                startActivity(new Intent(democlass.this,MainActivity.class));
                                finish();

                            }
                        });
                        gametimer.setText("Compeleted");
                        timer2.setText("Compeleted");
                        builder.create();
                        builder.show();
                    }
                }


    public int rndm()
    {


        i=r.nextInt(3);
        if(i==0) {
            sysimage.setImageResource(R.drawable.rock);
            return 0;
        }
        else if (i==1) {
            sysimage.setImageResource(R.drawable.paper);
            return 1;
        }
        else if(i==2) {
            sysimage.setImageResource(R.drawable.scissor);
            return 2;
        }
        return i;
    }
}
