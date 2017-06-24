/**
 * 
 */
package com.seven7.insurance.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seven7.insurance.feed.domain.FeedItem;

/**
 * @author Seven7
 *
 */
@Repository
public interface FeedItemRepository extends JpaRepository<FeedItem, String> {

}
