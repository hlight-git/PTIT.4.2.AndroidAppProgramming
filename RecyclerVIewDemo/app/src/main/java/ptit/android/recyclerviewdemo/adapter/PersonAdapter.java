package ptit.android.recyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ptit.android.recyclerviewdemo.R;
import ptit.android.recyclerviewdemo.model.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private List<Person> mList;
    private Context context;
    PersonItemListener personItemListener;

    public void setPersonItemListener(PersonItemListener personItemListener) {
        this.personItemListener = personItemListener;
    }

    public PersonAdapter(Context context, List<Person> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = mList.get(position);
        holder.image.setImageResource(person.getImage());
        holder.nameTextView.setText(person.getName());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, person.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    public Person getPersonAt(int position){
        return mList.get(position);
    }

    public void addPerson(Person person){
        mList.add(person);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView nameTextView;
//        CardView cardView;
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.itemImg);
            nameTextView = itemView.findViewById(R.id.itemTextView);
            itemView.setOnClickListener(this);
//            cardView = itemView.findViewById(R.id.itemCardView);
        }

        @Override
        public void onClick(View view) {
            personItemListener.onItemClicked(view, getAdapterPosition());
        }
    }

    public interface PersonItemListener{
        void onItemClicked(View view, int position);
    }
}
