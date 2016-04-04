package com.example.gazzol_j.ipokedroid.TeamPackage;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.gazzol_j.ipokedroid.R;

/**
 * Created by gazzol_j on 31/03/2016.
 */
public class TrainerChooseFragment extends Fragment {
    Integer selectedTrainer = null;
    View v;

    public static TrainerChooseFragment newInstance(){
        return new TrainerChooseFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = new View(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trainer_choose, container, false);

        final EditText name = (EditText) view.findViewById(R.id.trainer_choose_name);
        final FloatingActionButton button = (FloatingActionButton) view.findViewById(R.id.trainer_button);
        final GridView images = (GridView) view.findViewById(R.id.trainer_choose_image);

        button.hide();
        ImageAdapter adapter = new ImageAdapter(getContext());
        images.setAdapter(adapter);

        images.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (selectedTrainer != null && selectedTrainer == position) {
                    selectedTrainer = null;
                    view.setBackgroundColor(getContext().getColor(R.color.white));
                    button.hide();
                } else {
                    v.setBackgroundColor(getContext().getColor(R.color.white));
                    selectedTrainer = position;
                    button.show();
                    v = view;
                    view.setBackgroundColor(getContext().getColor(R.color.white));
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()) {
                    name.setError("Field needed");
                } else {
                    ((TeamBuilderActivity)getActivity()).getPokeTeam().getTrainer().setName(name.getText().toString());
                    ((TeamBuilderActivity)getActivity()).getPokeTeam().getTrainer().setPicture("trainer_" + (selectedTrainer + 1));
                    ((TeamBuilderActivity)getActivity()).changeFragment(1);
                }
            }
        });

        return view;
    }

    private class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private Integer[] trainersImg = {
                R.drawable.trainer_1, R.drawable.trainer_2, R.drawable.trainer_3,
                R.drawable.trainer_4, R.drawable.trainer_5, R.drawable.trainer_6,
                R.drawable.trainer_7, R.drawable.trainer_8, R.drawable.trainer_9,
                R.drawable.trainer_10
        };

        public ImageAdapter(Context context){
            mContext = context;
        }

        @Override
        public int getCount() {
            return trainersImg.length;
        }

        @Override
        public Object getItem(int position) {
            return trainersImg[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null){
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(0,5,0,5);
            }
            else {
                imageView = (ImageView) convertView;
            }

            imageView.setBackgroundColor(getContext().getColor(R.color.white));
            if (selectedTrainer != null && position == selectedTrainer) {
                imageView.setBackgroundColor(getContext().getColor(R.color.white));
            }
            imageView.setImageResource(trainersImg[position]);
            return imageView;
        }
    }
}