package com.example.gestiononglets.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.gestiononglets.MainActivity;
import com.example.gestiononglets.R;

import java.util.Locale;

/**
 * une instance de SeasonsFragment contient ici juste un label
 */
public class SeasonsFragment extends Fragment {
    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque SeasonsFragment instancié
    private String title;
    private int page;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";
    private Context mContext;

    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static SeasonsFragment newInstance(int position, String title) {
        SeasonsFragment fragment = new SeasonsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(title.equals("Saisons")){

            View view = inflater.inflate(R.layout.fragment_saisons, container, false);
            ImageView imageHiver = (ImageView) view.findViewById(R.id.imageView1);
            ImageView imagePrintemps= (ImageView) view.findViewById(R.id.imageView2);
            ImageView imageEte= (ImageView) view.findViewById(R.id.imageView3);
            ImageView imageAutomne= (ImageView) view.findViewById(R.id.imageView4);

            imageHiver.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(0);
                }
            });
            imagePrintemps.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(1);
                }
            });
            imageEte.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(2);
                }
            });
            imageAutomne.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // your code here
                    MainActivity a = (MainActivity) getActivity();
                    a.viewPager.setCurrentItem(3);
                }
            });


            imageHiver.setImageResource(SectionsPagerAdapter.getImage("hiver"));
            imagePrintemps.setImageResource(SectionsPagerAdapter.getImage("printemps"));
            imageEte.setImageResource(SectionsPagerAdapter.getImage("été"));
            imageAutomne.setImageResource(SectionsPagerAdapter.getImage("automne"));
            return view;


        }
        else {
            View view = inflater.inflate(R.layout.fragment_main, container, false);
            TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
            tvLabel.setText(page + " -- " + title);
            ImageView image;
            image = (ImageView) view.findViewById(R.id.imageView);
            image.setImageResource(SectionsPagerAdapter.getImage(title));
            return view;
        }

    }


    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String titre="";
        Drawable icone=null;
        switch (position) {
            case 0:
                titre = mContext.getString(R.string.titre_section4).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.winter);
                break;
            case 1:
                titre = mContext.getString(R.string.titre_section5).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.spring);
                break;
            case 2:
                titre = mContext.getString(R.string.titre_section6).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.summer);
                break;
            case 3:
                titre = mContext.getString(R.string.titre_section7).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.autumn);
                break;
        }
        SpannableString sb = new SpannableString(" " + titre);
        // un espace est ajouté pour séparer le texte de l'image

        icone.setBounds(0, 0, icone.getIntrinsicWidth(), icone.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(icone, ImageSpan.ALIGN_BASELINE);
        sb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }



}

