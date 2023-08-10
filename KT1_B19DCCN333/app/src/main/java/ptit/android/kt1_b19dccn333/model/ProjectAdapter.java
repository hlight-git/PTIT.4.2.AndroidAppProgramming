package ptit.android.kt1_b19dccn333.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ptit.android.kt1_b19dccn333.R;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.TQHViewHolder>{
    private Context context;
    private List<Project> listBackUp;
    private List<Project> list;
    private ItemClickListener itemClickListener;

    public ProjectAdapter(Context context, ItemClickListener itemClickListener){
        this.context = context;
        this.itemClickListener = itemClickListener;
        list = new ArrayList<>();
        listBackUp = new ArrayList<>();
    }
    public void filterList(List<Project> filterList){
        list = filterList;
        notifyDataSetChanged();
    }
    public List<Project> getListBackUp(){
        return listBackUp;
    }
    public Project getItem(int position){
        return list.get(position);
    }
    public void add(Project item){
        listBackUp.add(item);
        list.add(item);
        notifyDataSetChanged();
    }
    public void update(int position, Project item){
        listBackUp.set(position, item);
        list.set(position, item);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TQHViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new TQHViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TQHViewHolder holder, int position) {
        Project item = list.get(position);
        if (item == null){
            return;
        }

        holder.prjName.setText(item.getName());
        holder.startDay.setText("From " + item.getStartDay().toString());
        holder.endDay.setText("To " + item.getEndDay().toString());
        holder.isFinished.setChecked(item.isFinished());

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thong bao xoa");
                builder.setMessage("Ban chac chan muon xoa " + item.getName() + " chu?");
                builder.setIcon(R.drawable.ic_launcher_foreground);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listBackUp.remove(position);
                        list.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface ItemClickListener {
        void onItemClicked(View view, int position);
    }
    public class TQHViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView prjName, startDay, endDay;
        private CheckBox isFinished;
        private Button removeButton;

        public TQHViewHolder(@NonNull View itemView) {
            super(itemView);
            removeButton = itemView.findViewById(R.id.removeButton);
            prjName = itemView.findViewById(R.id.projectName);
            startDay = itemView.findViewById(R.id.startDay);
            endDay = itemView.findViewById(R.id.endDay);
            isFinished = itemView.findViewById(R.id.isFinished);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClicked(view, getAdapterPosition());
        }
    }
}
