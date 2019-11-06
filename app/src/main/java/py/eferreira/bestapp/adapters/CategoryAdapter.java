package py.eferreira.bestapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import py.eferreira.bestapp.R;
import py.eferreira.bestapp.entities.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    List<Category> dataSet;
    Context ctx;


    public CategoryAdapter(List<Category> dataSet, Context ctx) {
        this.dataSet = dataSet;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category, viewGroup, false);
        TextView tvTitle = view.findViewById(R.id.item_title);
        TextView tvDescription = view.findViewById(R.id.item_description);

        CategoryViewHolder viewHolder = new CategoryViewHolder(view, tvTitle, tvDescription);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int position) {
        categoryViewHolder.title.setText(dataSet.get(position).getTitle());
        categoryViewHolder.description.setText(dataSet.get(position).getDescription());

        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, dataSet.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.dataSet.size();
    }



    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;

        public CategoryViewHolder(@NonNull View itemView, TextView title, TextView description) {
            super(itemView);
            this.title = title;
            this.description = description;
        }
    }
}
