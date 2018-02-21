package code.challenge.stocktwits;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import code.challenge.stocktwits.model.entity.Trending;

/**
 * Created by Philip K. Han on 2/20/18.
 */

public class TrendingAdapter extends Adapter<TrendingAdapter.SymbolViewHolder> {

  private Trending trending;
  private OnClick onClick;

  public TrendingAdapter(Trending trending, OnClick onClick) {
    this.trending = trending;
    this.onClick = onClick;
  }

  @Override
  public SymbolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new SymbolViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.two_line_list_item, parent, false));
  }

  @Override
  public void onBindViewHolder(SymbolViewHolder holder, int position) {
    holder.text1.setText(trending.getSymbols().get(position).getSymbol());
    holder.text2.setText(trending.getSymbols().get(position).getTitle());
    //holder.text1.setOnClickListener(view -> {
    ((View) holder.text1.getParent()).setOnClickListener(view -> {
      if (onClick != null) onClick.onClick(holder.text1.getText().toString());
    });
  }

  @Override
  public int getItemCount() {
    return trending.getSymbols().size();
  }

  static class SymbolViewHolder extends RecyclerView.ViewHolder {

    private TextView text1, text2;

    public SymbolViewHolder(View itemView) {
      super(itemView);
      text1 = itemView.findViewById(android.R.id.text1);
      text2 = itemView.findViewById(android.R.id.text2);
    }

  }

  interface OnClick {
    void onClick(String symbol);
  }

}
