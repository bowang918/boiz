Ext.define('App.view.profitloss.ProfitLoss', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.profitloss',
	requires : [ 'Ext.grid.feature.Grouping', 'App.store.ProfitLoss' ],

	itemId : 'profitloss',
	cls : 'dynamic-pl-grid',

	// controller: 'profitloss',

	viewModel : {
		type : 'profitloss'
	},

	enableLocking : true,

	bind : '{feedItems}',

	features : [ {
		ftype : 'grouping',
		id : 'profitLossGrouper',
		groupHeaderTpl : '<b>{name}</b>',
		startCollapsed : false
	} ],

	columns : [ {
		text : '姓名',
		dataIndex : 'clientName',
		sortable : false,
		hideable : false,
		flex : 1
	}, {
		text : '身份证',
		dataIndex : 'idNumber',
		flex : 1
	}, {
		text : '手机',
		dataIndex : 'phone',
		flex : 1
	}, {
		text : '车牌',
		dataIndex : 'plateNumber',
		flex : 1
	}, {
		text : '车型',
		dataIndex : 'vehicleType',
		flex : 1
	}, {
		text : '车架',
		dataIndex : 'frameNumber',
		flex : 1
	}, {
		text : '发动机',
		dataIndex : 'engineNumber',
		flex : 1
	}, {
		text : '城市',
		dataIndex : 'city',
		flex : 1
	}, {
		text : '批次',
		dataIndex : 'batch',
		flex : 1
	} ]
	// tbar: [{
	// text: 'Quarter',
	// width: 150,
	// textAlign: 'left',
	// reference: 'quartersButton',
	// menu: {
	// id: 'quarter-menu',
	// cls: 'pl-option-menu',
	// items: []
	// }
	// }, {
	// text: 'Region',
	// width: 150,
	// textAlign: 'left',
	// reference: 'regionsButton',
	// menu: {
	// id: 'region-menu',
	// cls: 'pl-option-menu',
	// items: []
	// }
	// }],

	// These properties are aspects of the view that get used to create dynamic
	// grid
	// columns and menu items.

//	regionColumn : {
//		text : 'Region',
//		dataIndex : 'region',
//		menuDisabled : true,
//		sortable : false,
//		resizable : false,
//		hideable : false,
//		groupable : false,
//		locked : true,
//
//		plugins : 'responsive',
//		responsiveConfig : {
//			'width < 600' : {
//				width : 150
//			},
//			'width >= 600' : {
//				width : 320
//			}
//		}
//	},
//
//	menuItemDefaults : {
//		checked : true,
//		hideOnClick : false
//	},
//
//	quarterColumnDefaults : {
//		formatter : 'currency',
//		flex : 1,
//		minWidth : 130,
//		align : 'right',
//		groupable : false,
//		menuDisabled : true,
//		resizable : false,
//		sortable : false,
//		summaryType : 'sum'
//	}
});
