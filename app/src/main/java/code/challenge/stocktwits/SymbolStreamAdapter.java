package code.challenge.stocktwits;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import code.challenge.stocktwits.model.entity.Message;
import code.challenge.stocktwits.model.entity.SymbolStream;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class SymbolStreamAdapter extends RecyclerView.Adapter<SymbolStreamAdapter.MessageViewHolder> {

  private static final String TAG = SymbolStreamAdapter.class.getSimpleName();
  private SymbolStream symbolStream;
  private OnAvatarClick onAvatarClick;

  public SymbolStreamAdapter(SymbolStream symbolStream, OnAvatarClick onAvatarClick) {
    this.symbolStream = symbolStream;
    this.onAvatarClick = onAvatarClick;
  }

  @Override
  public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_layout, parent, false));
  }

  @Override
  public void onBindViewHolder(MessageViewHolder holder, int position) {
    Message message = symbolStream.getMessages().get(position);
    Picasso.with(holder.itemView.getContext())
        .load(message.getUser().getAvatarUrl())
        .into(holder.avatarImageView);
    holder.avatarImageView.setOnClickListener(view -> {
      Log.i(TAG, "onBindViewHolder: ");
      if (onAvatarClick != null) onAvatarClick.onClick(message.getUser().getName(), message.getUser().getJoinDate(), message.getUser().isOfficial());
    });
    holder.messageTextView.setText(message.getBody());
    holder.userNameTextView.setText(message.getUser().getUsername());
  }

  @Override
  public int getItemCount() {
    return symbolStream.getMessages().size();
  }

  static class MessageViewHolder extends RecyclerView.ViewHolder {

    private ImageView avatarImageView;
    private TextView userNameTextView, messageTextView;

    public MessageViewHolder(View itemView) {
      super(itemView);
      avatarImageView = itemView.findViewById(R.id.avatarImageView);
      userNameTextView = itemView.findViewById(R.id.userNameTextView);
      messageTextView = itemView.findViewById(R.id.messageTextView);
    }
  }
  interface OnAvatarClick {
    void onClick(String name, String joinDate, boolean official);
  }

}
