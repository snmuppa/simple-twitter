package com.fetherz.saim.twistertwit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fetherz.saim.twistertwit.R;
import com.fetherz.saim.twistertwit.images.ImageLoaderImpl;
import com.fetherz.saim.twistertwit.models.client.Tweet;
import com.fetherz.saim.twistertwit.utils.GenericUtil;

import java.util.List;

/**
 * Created by sm032858 on 3/26/17.
 */
public class TimelineRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Tweet> mTweets;
    Context mContext;

    static final int TEXT_TWEET = 0;
    static final int IMAGE_TWEET = 1;
    static final int VIDEO_TWEET = 2;

    static final String IMAGE_MEDIA_TYPE = "photo";
    static final String VIDEO_MEDIA_TYPE = "video";

    static final String RETWEETED_TEXT = "retweedted";

    public TimelineRecyclerViewAdapter(Context context, List<Tweet> tweets){
        this.mContext = context;
        this.mTweets = tweets;
    }

    /**
     * Get the tweet count
     * @return
     */
    @Override
    public int getItemCount(){
        return this.mTweets.size();
    }

    /**
     * Get the view type based on the media type
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position){
        Tweet tweet = mTweets.get(position);

        if(tweet.getMediaType().equalsIgnoreCase(IMAGE_MEDIA_TYPE)){
            return IMAGE_TWEET;
        }
        else if(tweet.getMediaType().equalsIgnoreCase(VIDEO_MEDIA_TYPE)){
            return VIDEO_TWEET;
        }

        return TEXT_TWEET;
    }

    /**
     * Inflate the view holder based on the view type
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case IMAGE_TWEET:
                View imageView = inflater.inflate(R.layout.image_tweet, parent, false);
                viewHolder = new ImageTweetViewHolder(mContext, imageView, mTweets);
            break;

            case TEXT_TWEET:
            default: //TODO: add logic for video tweet
                View textView = inflater.inflate(R.layout.text_tweet, parent, false);
                viewHolder = new TextTweetViewHolder(mContext, textView, mTweets);
            break;
        }

        return viewHolder;
    }

    /**
     * Bind the view holder based on the view type
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case IMAGE_TWEET:
                ImageTweetViewHolder imageTweetViewHolder = (ImageTweetViewHolder) holder;
                bindImageTweetViewHolder(imageTweetViewHolder, position);
            break;

            case TEXT_TWEET:
            default: //TODO: add logic for video tweet
                TextTweetViewHolder textTweetViewHolder = (TextTweetViewHolder) holder;
                bindTextTweetViewHolder(textTweetViewHolder, position);
            break;
        }

    }

    /***
     * Binds the tweet text view
     * @param viewHolder
     * @param position
     */
    private void bindTextTweetViewHolder(TextTweetViewHolder viewHolder, int position) {
        Tweet tweet = mTweets.get(position);

        if(tweet != null){
            if(tweet.getHasRetweetStatus()){
                viewHolder.mTvRetweetedUserName.setVisibility(View.VISIBLE);
                viewHolder.mIvRetweeted.setVisibility(View.VISIBLE);

                viewHolder.mTvRetweetedUserName.setText(String.format("%s%s %s", "@", tweet.getRetweetUser().getScreenName(), RETWEETED_TEXT));
            }else {
                viewHolder.mTvRetweetedUserName.setVisibility(View.GONE);
                viewHolder.mIvRetweeted.setVisibility(View.GONE);
            }

            viewHolder.mTvUserName.setText(tweet.getUser().getName());

            viewHolder.mTvTweetText.setText(tweet.getText());

            ImageLoaderImpl imageLoader = new ImageLoaderImpl();
            imageLoader.loadImage(tweet.getUser().getProfileImageUrl(), viewHolder.mIvProfilePicture);

            viewHolder.mTvScreenName.setText(String.format("%s%s", "@", tweet.getUser().getScreenName()));
            viewHolder.mTvRelativeTime.setText(GenericUtil.getRelativeTimeAgo(tweet.getCreatedAt()));

            viewHolder.mIvReply.setTag(tweet);

            viewHolder.mTvFavorites.setText(tweet.getFavouriteCount());
            viewHolder.mIvFavorite.setTag(tweet);
            if(tweet.getFavorited()){
                viewHolder.mIvFavorite.setImageResource(R.drawable.ic_heart);
            }else {
                viewHolder.mIvFavorite.setImageResource(R.drawable.ic_heart_outline);
            }

            viewHolder.mTvRetweets.setText(tweet.getFavouriteCount());
            viewHolder.mIvRetweeted.setTag(tweet);
            if(tweet.getReTweeted()){
                viewHolder.mIvRetweeted.setImageResource(R.drawable.ic_retweet_green);
            }else {
                viewHolder.mIvRetweeted.setImageResource(R.drawable.ic_retweet);
            }
        }
    }

    /**
     * Binds the tweet image view
     * @param viewHolder
     * @param position
     */
    private void bindImageTweetViewHolder(ImageTweetViewHolder viewHolder, int position) {
        Tweet tweet = mTweets.get(position);

        if(tweet != null){
            if(tweet.getHasRetweetStatus()){
                viewHolder.mTvRetweetedUserName.setVisibility(View.VISIBLE);
                viewHolder.mIvRetweeted.setVisibility(View.VISIBLE);

                viewHolder.mTvRetweetedUserName.setText(String.format("%s%s %s", "@", tweet.getRetweetUser().getScreenName(), RETWEETED_TEXT));
            }else {
                viewHolder.mTvRetweetedUserName.setVisibility(View.GONE);
                viewHolder.mIvRetweeted.setVisibility(View.GONE);
            }

            viewHolder.mTvUserName.setText(tweet.getUser().getName());

            viewHolder.mTvTweetText.setText(tweet.getText());

            ImageLoaderImpl imageLoader = new ImageLoaderImpl();
            imageLoader.loadImage(tweet.getUser().getProfileImageUrl(), viewHolder.mIvProfilePicture);

            viewHolder.mTvScreenName.setText(String.format("%s%s", "@", tweet.getUser().getScreenName()));
            viewHolder.mTvRelativeTime.setText(GenericUtil.getRelativeTimeAgo(tweet.getCreatedAt()));

            viewHolder.mIvReply.setTag(tweet);

            viewHolder.mTvFavorites.setText(tweet.getFavouriteCount());
            viewHolder.mIvFavorite.setTag(tweet);
            if(tweet.getFavorited()){
                viewHolder.mIvFavorite.setImageResource(R.drawable.ic_heart);
            }else {
                viewHolder.mIvFavorite.setImageResource(R.drawable.ic_heart_outline);
            }

            viewHolder.mTvRetweets.setText(tweet.getFavouriteCount());
            viewHolder.mIvRetweeted.setTag(tweet);
            if(tweet.getReTweeted()){
                viewHolder.mIvRetweeted.setImageResource(R.drawable.ic_retweet_green);
            }else {
                viewHolder.mIvRetweeted.setImageResource(R.drawable.ic_retweet);
            }

            imageLoader = new ImageLoaderImpl();
            imageLoader.loadImage(tweet.getMediaUrl(), viewHolder.mIvTweetImage);
        }
    }

    /**
     * Clear all the tweets
     */
    public void clear() {
        mTweets.clear();
        notifyDataSetChanged();
    }

    /***
     * Adds a list of tweets
     * @param tweets
     */
    public void addAll(List<Tweet> tweets) {
        mTweets.addAll(tweets);
        notifyDataSetChanged();
    }
}
