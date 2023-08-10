package ptit.android.demo.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ptit.android.demo.R;

public class AlphabetAdapter extends ArrayAdapter<Alphabet> {
    private Activity context;
    private Alphabet[] list;
    public AlphabetAdapter(@NonNull Activity context, @NonNull Alphabet[] objects) {
        super(context, R.layout.item_alphabet, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.item_alphabet, null, true);
        ImageView img = row.findViewById(R.id.alphabetImg);
        TextView title = row.findViewById(R.id.alphabetTitle);
        TextView desc = row.findViewById(R.id.alphabetDesc);
        img.setImageResource(list[position].getImg());
        title.setText(list[position].getTitle());
        desc.setText(list[position].getDesc());
        return row;
    }

    @Nullable
    @Override
    public Alphabet getItem(int position) {
        return list[position];
    }
}
