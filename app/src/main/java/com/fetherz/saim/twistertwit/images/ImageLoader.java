package com.fetherz.saim.twistertwit.images;

import com.fetherz.saim.twistertwit.utils.DynamicHeightImageView;

/**
 * Created by sm032858 on 3/25/17.
 */

public interface ImageLoader {
    void loadImage(String url, DynamicHeightImageView imageView);
}
