package e.wolfsoft1.scanhome.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import e.wolfsoft1.scanhome.HomeActivity;
import e.wolfsoft1.scanhome.ModelClasses.PropertyRecyclerModel;
import e.wolfsoft1.scanhome.PropertyDetailsActivity;
import e.wolfsoft1.scanhome.R;

/**
 * Created by wolfsoft1 on 8/3/18.
 */

public class PropertyRecyclerAdapter  extends RecyclerView.Adapter<PropertyRecyclerAdapter.MyViewHolder> {

        Context context;
        private ArrayList<Integer> IMAGES;

    public void SetImages(Context context, ArrayList<Integer> IMAGES) {
        this.context = context;
        this.IMAGES = IMAGES;
    }

    private List<PropertyRecyclerModel> OfferList;


        public class MyViewHolder extends RecyclerView.ViewHolder {


            TextView propertyName,street1,street2,amount,bedCount,carParking,swimmingpool;
            ImageView ivRumah;

            public MyViewHolder(View view) {
                super(view);

                propertyName=(TextView) view.findViewById(R.id.propertyName);
                street1=(TextView)view.findViewById(R.id.street1);
                street2=(TextView)view.findViewById(R.id.street2);
                amount=(TextView) view.findViewById(R.id.amount);
                bedCount=(TextView) view.findViewById(R.id.bedCount);
                carParking=(TextView) view.findViewById(R.id.carParking);
                swimmingpool=(TextView) view.findViewById(R.id.swimmingPool);
                ivRumah= view.findViewById(R.id.imageRumah);
            }

        }


        public PropertyRecyclerAdapter(Context mainActivityContacts, List<PropertyRecyclerModel> offerList) {
            this.OfferList = offerList;
            this.context = mainActivityContacts;
        }

        @Override
        public PropertyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_view, parent, false);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    context.startActivity(new Intent(context, PropertyDetailsActivity.class));

                    //startActivity(intent);
                }
            });

            return new PropertyRecyclerAdapter.MyViewHolder(itemView);


        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            PropertyRecyclerModel lists = OfferList.get(position);

            holder.propertyName.setText(lists.getPropertyName());
            holder.street1.setText(lists.getStreet1());
            holder.street2.setText(lists.getStreet2());
            holder.amount.setText(lists.getAmount());
            holder.bedCount.setText(lists.getBedCount());
            holder.carParking.setText(lists.getCarParking());
            holder.swimmingpool.setText(lists.getSwimmingpool());
            //holder.ivRumah.setImageResource(IMAGES.get(position));
        }


        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)


        @Override
        public int getItemCount() {
            return OfferList.size();

        }

    }


