/**
 * 
 */
package com.seven7.insurance.feed.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.seven7.insurance.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Seven7
 *
 */
@Entity
@Table
@Setter
@Getter
@Slf4j
public class FeedItem extends AbstractPersistable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3941842230290611026L;

	// 姓名
	private String clientName;
	// 身份证
	private String idNumber;
	// 手机1
	private String phone;
	// 车牌
	private String plateNumber;
	// 车型
	private String vehicleType;
	// 车架
	private String frameNumber;
	// 发动机
	private String engineNumber;
	// 初登时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date registed;
	// 到期时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDateTime;
	// 城市
	private String city;
	// 文本格式到期日
	private String dueDateTimeString;
	// 批次
	private String batch;
	// 文本格式初登
	private String registedString;

	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private FeedFile feed;
	
	@JsonInclude
	public String getGroup(){
		return feed.getId() + "-" + feed.getFileName();
	}

	public static FeedItem from(Row row) {
		FeedItem item = new FeedItem();
		
		item.setClientName(String.valueOf(getCellValue(row.getCell(0))));
		item.setIdNumber(String.valueOf(getCellValue(row.getCell(1))));
		item.setPhone(String.valueOf(getCellValue(row.getCell(2))));
		item.setPlateNumber(String.valueOf(getCellValue(row.getCell(3))));
		item.setVehicleType(String.valueOf(getCellValue(row.getCell(4))));
		item.setFrameNumber(String.valueOf(getCellValue(row.getCell(5))));
		item.setEngineNumber(String.valueOf(getCellValue(row.getCell(6))));
//		item.setRegisted(DateFormat.parse(getCellValue(row.getCell(7))));
//		item.setDueDateTime(String.valueOf(getCellValue(row.getCell(8))));
		item.setCity(String.valueOf(getCellValue(row.getCell(9))));
		item.setRegistedString(String.valueOf(getCellValue(row.getCell(10))));
		item.setBatch(String.valueOf(getCellValue(row.getCell(11))));
		item.setRegistedString(String.valueOf(getCellValue(row.getCell(12))));
		
		return item;
	}

	public static Object getCellValue(Cell cell) {
		Object value = null;

		if (cell != null) {
			switch (cell.getCellTypeEnum()) {

			case FORMULA:
				value = cell.getCellFormula();
				break;

			case NUMERIC:
				value = cell.getNumericCellValue();
				break;

			case STRING:
				value = cell.getStringCellValue();
				break;

			case BLANK:
				value = "";
				break;

			case BOOLEAN:
				value = cell.getBooleanCellValue();
				break;

			case ERROR:
				value = cell.getErrorCellValue();
				break;

			default:
				value = cell.getStringCellValue();
			}
			log.debug("CELL col=" + cell.getColumnIndex() + " VALUE=" + value);
		}
		return value;
	}

}
