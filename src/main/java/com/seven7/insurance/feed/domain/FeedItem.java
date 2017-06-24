/**
 * 
 */
package com.seven7.insurance.feed.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.seven7.insurance.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Seven7
 *
 */
@Entity
@Table
@Setter
@Getter
public class FeedItem extends AbstractPersistable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3941842230290611026L;

}
