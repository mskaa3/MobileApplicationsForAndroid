package com.example.lab5;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */

public interface ListFragmentInteractionListener {
    void onDeleteItem(ItemData item);

    List<ItemData> getRepositoryList();

}
