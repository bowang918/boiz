Ext.define('App.store.ProfitLoss', {
    extend: 'Ext.data.Store',
    alias: 'store.profitloss',

    model: 'App.model.FullProfitloss',

    proxy: {
        type: 'ajax',
        url: 'resources/data/full_data.json',
        reader: 'json'
    }
});
