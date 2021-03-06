package com.certis_base_app.ui.messaging;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.certis_base_app.R;
import com.certis_base_app.model.MessageCard;
import java.util.Calendar;
import java.util.List;

public class MessageInboxAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Calendar currentDate;
    private List<MessageCard> messageCardList;

    public MessageInboxAdapter(List<MessageCard> list) {
        this.messageCardList = list;
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MessageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_officer_message_sent, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MessageViewHolder messageViewHolder = (MessageViewHolder) viewHolder;
        messageViewHolder.itemView.setTag(Integer.valueOf(i));
        if(i==0)
            messageViewHolder.date.setVisibility(View.VISIBLE);
        else
            messageViewHolder.date.setVisibility(View.GONE);
        messageViewHolder.message.setText(messageCardList.get(i).getMessageText());
        messageViewHolder.messageSentTime.setText(messageCardList.get(i).getMessageSentTime());
    }

    public int getItemCount() {
        return this.messageCardList != null ? this.messageCardList.size() : 0;
    }

    public void setMessages(MessageCard messages) {
        this.messageCardList.add(messages);
        notifyDataSetChanged();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView acknowledgedText;
        TextView date;
        TextView message;
        TextView messageSentTime;

        MessageViewHolder(View view) {
            super(view);
            this.date = view.findViewById(R.id.tv_date);
            this.message = view.findViewById(R.id.tv_message);
            this.messageSentTime = view.findViewById(R.id.tv_sent_time);
            this.acknowledgedText = view.findViewById(R.id.tv_acknowledged);
        }
    }
}
