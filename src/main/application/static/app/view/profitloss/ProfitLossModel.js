Ext.define('App.view.profitloss.ProfitLossModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.profitloss',

	requires : [ 'Ext.data.Store' ],

	stores : {
		feedItems : {
			type : 'store',
			fields : [ 'clientName', 'idNumber', 'phone', 'plateNumber',
					'vehicleType', 'frameNumber', 'engineNumber', 'city',
					'batch', 'group' ],

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
