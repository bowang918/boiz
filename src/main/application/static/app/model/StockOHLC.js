Ext.define('App.model.StockOHLC', {
    extend: 'App.model.Base',

    fields: [
        'company',
        'time',
        'open',
        'high',
        'low',
        'close'
    ]
});
