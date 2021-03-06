package com.kobe.ubersplash.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kobe.ubersplash.R;
import com.kobe.ubersplash.activity.OrganizationInfoMore;
import com.kobe.ubersplash.utils.Article;
import com.kobe.ubersplash.utils.OrganizationArticles;
import com.kobe.ubersplash.utils.TeanBeen;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Jack on 2017/2/9.
 */

public class OrganizationRecyclerAdapter extends RecyclerView.Adapter<OrganizationRecyclerAdapter.ViewHolder> {

    private List<OrganizationArticles.OrArticle> orArticles;
    private Context mContext;


    public OrganizationRecyclerAdapter(Context mContext, List<OrganizationArticles.OrArticle> articleList) {
        this.orArticles = articleList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_easy_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final OrganizationArticles.OrArticle article = orArticles.get(position);
        if (!article.getImg().equals("")) {
            Picasso.with(mContext)
                    .load(article.getImg())
                    .placeholder(R.mipmap.loading2)
                    .error(R.mipmap.lose)
                    .into(holder.organizationCircleImage);
        }
        holder.organizationFromTitleText.setText("学生会");
        holder.organizationTitleText.setText(article.getTitle());
        holder.organizationContentText.setText(article.getDigest());
        holder.organizationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "学生会", Toast.LENGTH_SHORT).show();
            }
        });
        holder.organizationContentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OrganizationInfoMore.class);
                intent.putExtra("Article", article);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //return girlsList.size();
        return orArticles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout organizationLayout, organizationContentLayout;
        private CircleImageView organizationCircleImage;
        private TextView organizationFromTitleText, organizationTitleText, organizationContentText;

        public ViewHolder(View itemView) {
            super(itemView);
            organizationLayout = (LinearLayout) itemView.findViewById(R.id.organization_id_layout);
            organizationContentLayout = (LinearLayout) itemView.findViewById(R.id.organization_content_layout);
            organizationCircleImage = (CircleImageView) itemView.findViewById(R.id.organization_circleimage);
            organizationFromTitleText = (TextView) itemView.findViewById(R.id.organization_fromName);
            organizationTitleText = (TextView) itemView.findViewById(R.id.organization_title);
            organizationContentText = (TextView) itemView.findViewById(R.id.organization_content);
        }
    }

}
