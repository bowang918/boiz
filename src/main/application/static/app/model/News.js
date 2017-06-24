Ext.define('App.model.News', {
    extend: 'App.model.Base',

    fields: [
        'type',
        {name: 'date', type: 'date', dateFormat: 'Y-m-d H:i:s'},
        'time',
        'author',
        'group',
        'image',
        'title',
        'paragraph'
    ]
});
