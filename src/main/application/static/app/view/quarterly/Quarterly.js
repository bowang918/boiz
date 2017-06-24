Ext.define('App.view.quarterly.Quarterly', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.quarterly',

	requires : [ 'Ext.chart.axis.Time', 'Ext.chart.series.CandleStick',
			'Ext.chart.series.Line', 'Ext.chart.axis.Numeric',
			'Ext.draw.modifier.Highlight', 'Ext.chart.axis.Time',
			'Ext.chart.interactions.ItemHighlight',
			'Ext.chart.interactions.PanZoom', 'App.view.feed.FeedList' ],

	itemId : 'quarterly',

	cls : 'quarterly-main',

	config : {
		activeState : null,
		defaultActiveState : 'AAPL'
	},

	controller : 'quarterly',

	viewModel : {
		type : 'quarterly'
	},

	layout : {
		type : 'vbox',
		align : 'stretch'
	},

	scrollable : 'y',

	items : [ {
		width : '100%',
		xtype : 'feedupload'
	}, {
		xtype : 'feedlist',
		bind : '{feeds}',

	} ],

	validStates : {
		AAPL : 1,
		GOOG : 1
	},

	isValidState : function(state) {
		return state in this.validStates;
	}
});
