Ext.define('App.view.kpi.KpiModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.kpi',

    requires: [
        'App.model.Kpi',
        'App.store.Kpi'
    ],

    data: {
        // This property is placed in the ViewModel by routing
        // kpiCategory: null
    },

    stores: {
        kpiMain: {
            type: 'kpi',
            autoLoad: true,
            filters: {
                property: 'category',
                value: '{kpiCategory}'
            }
        }
    }
});
