Ext.define('App.view.profitloss.ProfitLossModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.profitloss',

    requires: [
        'App.model.MetaProfitloss',
        'App.model.FullProfitloss'
    ],

    stores: {
        metaProfitLoss: {
            model: 'App.model.MetaProfitloss',
            autoLoad: true,

            listeners: {
                load: 'onMetaDataLoad'
            },

            proxy: {
                type: 'ajax',
                url: 'resources/data/meta_data.json',

                reader: {
                    type: 'json'
                }
            }
        }
    }
});
