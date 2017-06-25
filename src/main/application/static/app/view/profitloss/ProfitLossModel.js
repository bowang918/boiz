Ext.define('App.view.profitloss.ProfitLossModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.profitloss',

	requires : [ 'Ext.data.Store' ],

	stores : {
		feedItems : {
			type : 'store',
			fields : [ 'clientName', 'idNumber', 'phone', 'plateNumber',
					'vehicleType', 'frameNumber', 'engineNumber', 'city','dueDateTimeString','registedString',
					'batch', 'group', {
						name : 'registed',
						type : 'date',
						dateFormat : 'time'
					}, {
						name : 'dueDateTime',
						type : 'date',
						dateFormat : 'time'
					} ],

			proxy : {
				type : 'direct',
				directFn : 'feedController.listFeedItems',
				reader : {
					type : 'json',
					rootProperty : 'records'
				}
			},
			groupField : 'group',
			autoLoad : true
		}
	}
});
