package com.example.forproject.bongsim;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by forProject on 2015-07-20.
 */
public class MsgAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MyMessage> MyMessages;

    public MsgAdapter(Context context, ArrayList<MyMessage> MyMessages) {
        super();
        this.context = context;
        this.MyMessages = MyMessages;
    }

    @Override
    public int getCount() {
        return MyMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return MyMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return MyMessages.get(position).IsImgAsw();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyMessage MyMessage = (MyMessage) getItem(position);

        //ViewHolder holder;


        if (convertView == null) {
            // holder = new ViewHolder();
            switch (MyMessage.IsImgAsw()) {
                case 0:
                    convertView = LayoutInflater.from(context).inflate(R.layout.msg_row, parent, false);
                    break;
                case 1:
                    convertView = LayoutInflater.from(context).inflate(R.layout.msg_row_img, parent, false);
                    break;
            }

/*
            if (message.isImgAsw) {
                convertView = LayoutInflater.from(context).inflate(R.layout.msg_row_img, parent, false);
                // holder.imgMessage = (ImageView) convertView.findViewById(R.id.msg_img);
                //convertView.setTag(R.id.imgId,holder);
            } else {
                convertView = LayoutInflater.from(context).inflate(R.layout.msg_row, parent, false);
                // holder.message = (TextView)convertView.findViewById(R.id.msg_text);
                //convertView.setTag(R.id.textId,holder);
            }
*/


        }

        /*else {
            if (message.isImgAsw) {
                holder = (ViewHolder) convertView.getTag(R.id.imgId);
            }
            //else{
            holder = (ViewHolder) convertView.getTag(R.id.textId);
            //}

        }*/


        switch (MyMessage.IsImgAsw()) {
            case 0:
                TextView textHolder = (TextView) convertView.findViewById(R.id.msg_text);
                textHolder.setText(MyMessage.getMessage());

                //LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)holder.message.getLayoutParams();
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) textHolder.getLayoutParams();
                if (MyMessage.isMine()) {
                    //holder.message.setBackgroundResource(R.drawable.sendmg);
                    textHolder.setBackgroundResource(R.drawable.sendmg);
                    textHolder.setTextColor(context.getResources().getColor(R.color.sendMediumColor));
                    lp.gravity = Gravity.RIGHT;
                } else {

                    // holder.message.setBackgroundResource(R.drawable.getmg);
                    textHolder.setBackgroundResource(R.drawable.getmg);
                    textHolder.setTextColor(context.getResources().getColor(R.color.textColor));
                    lp.gravity = Gravity.LEFT;
                }

                //holder.message.setLayoutParams(lp);
               /* holder.message.setTextSize(17);
                holder.message.setTextColor(context.getResources().getColor(R.color.textColor));*/

                textHolder.setTextSize(17);
                //textHolder.setTextColor(context.getResources().getColor(R.color.textColor));
                break;

            case 1:
                ImageView imgHolder = (ImageView) convertView.findViewById(R.id.msg_img);
                imgHolder.setImageResource(MyMessage.getId());
                break;

        }

/*        if (message.isImgAsw) {
            //holder
            //holder.imgMessage.setImageResource(message.id);//----------
            ImageView imgHolder = (ImageView) convertView.findViewById(R.id.msg_img);
            //imgHolder.setImageResource(message.id);//----------
        } else {
            //holder.message.setText(message.getMessage());

            TextView textHolder = (TextView) convertView.findViewById(R.id.msg_text);
            textHolder.setText(message.getMessage());

            //LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)holder.message.getLayoutParams();
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) textHolder.getLayoutParams();
            if (message.isMine()) {
                //holder.message.setBackgroundResource(R.drawable.sendmg);
                textHolder.setBackgroundResource(R.drawable.sendmg);
                lp.gravity = Gravity.RIGHT;
            } else {
                // holder.message.setBackgroundResource(R.drawable.getmg);
                textHolder.setBackgroundResource(R.drawable.getmg);
                lp.gravity = Gravity.LEFT;
            }
            //holder.message.setLayoutParams(lp);
            holder.message.setTextSize(17);
            holder.message.setTextColor(context.getResources().getColor(R.color.textColor));

            textHolder.setTextSize(17);
            textHolder.setTextColor(context.getResources().getColor(R.color.textColor));
        }*/

        return convertView;
    }

/*
    private static class ViewHolder {
        TextView message;
        ImageView imgMessage;
    }
*/
}
