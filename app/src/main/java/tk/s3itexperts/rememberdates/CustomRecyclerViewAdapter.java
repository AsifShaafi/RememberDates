package tk.s3itexperts.rememberdates;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Asif Imtiaz Shaafi on 9/17/2016.
 * Email: a15shaafi.209@gmail.com
 */
public class CustomRecyclerViewAdapter
        extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder>{

    private static final String TAG = "CustomRecyclerViewAdapter";

    // TODO: 9/17/2016 create a list that contains the titles and other info's to display


    /***********************************************************************************
        this method gets the layout which will be shown to the user and
     gets it's reference to use it
    ************************************************************************************/
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row_layout, parent, false);

        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bind("list created and ready to preview on screen");
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    /***********************************************************************************
        a view holder class that get references to the list's row items and populate them
     with right data that come from the server/database to show the user the titles of
     the events
    ************************************************************************************/
    protected static class CustomViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        private static final String TAG = "CustomViewHolder";
        private static int count = 0;

        @BindView(R.id.title_text)
        TextView title_text;
        @BindView(R.id.alarm_icon)
        ImageView alarm_icon;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            alarm_icon.setOnClickListener(this);

            Log.i(TAG, "CustomViewHolder: got called");
        }

        /***********************************************************************************
            a public method that takes the titles, dates and the boolean value of if the
         alarm is turned off or on and displays/sets them to appropriate views
        ************************************************************************************/
        public void bind(String msg)
        {
            // TODO: 9/17/2016 set this method to get and set right data to show the user

            title_text.setText(msg);
        }

        /***********************************************************************************
         on click listener for the recycler view to show the details of the event
         ************************************************************************************/
        @Override
        public void onClick(View view) {
            if (count % 2 == 0)
            {
                alarm_icon.setImageResource(R.drawable.alarm_off);
            }
            else {
                alarm_icon.setImageResource(R.drawable.alarm_on);
            }

            count++;
        }
    }
}
