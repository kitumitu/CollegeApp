package kritika.in.collegeapp.ui.adapter;

import android.view.View;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import kritika.in.collegeapp.R;
import kritika.in.collegeapp.subjects;

/**
 * Created by dell on 22-Jun-17.
 */

public class MyAttendancePageAdapter extends RecyclerView
        .Adapter<MyAttendancePageAdapter
        .subjectsHolder> {
    private static String LOG_TAG = "MyAdapter";
    private ArrayList<subjects> dataset;
    private static MyClickListener myClickListener;

    public static class subjectsHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView sub_name;
        TextView sub_code;

        public subjectsHolder(View itemView) {
            super(itemView);
            sub_name = (TextView) itemView.findViewById(R.id.sub_name);
                        Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyAttendancePageAdapter(ArrayList<subjects> myDataset) {
        dataset = myDataset;
    }

    @Override
    public subjectsHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attendance_view_item, parent, false);

        subjectsHolder p = new subjectsHolder(view);
        return p;
    }

    @Override
    public void onBindViewHolder(subjectsHolder holder, int position) {
        holder.sub_name.setText(dataset.get(position).getSub_name());

    }

    public void addItem(subjects dataObj, int index) {
        dataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        dataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);

    }
}
