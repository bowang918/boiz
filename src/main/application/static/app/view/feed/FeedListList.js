Ext.define('App.view.feed.FeedList', {
    extend: 'Ext.view.View',
    alias: 'widget.feedlist',

    cls: 'quarterly-dataview',

    itemSelector: 'div.thumb-wrap',

    tpl: [
        '<tpl for=".">',
        // Break every four quarters
            '<tpl if="xindex % 4 === 1">',
                '<div class="statement-type">{[Ext.Date.format(values.uploaded, Ext.Date.patterns.YearMonthZh)]}</div>',
            '</tpl>',

            '<div class="thumb-wrap">',
                '<a class="thumb" href="{url}" target="_blank">',
                    '<div class="thumb-icon {type}"></div>',
                    '<div class="thumb-title-container">',
                    '<div class="thumb-title">{fileName}</div>',
                    '<div class="thumb-title-small"> {uploadedByUser} 上传于: {[Ext.Date.format(values.uploaded, Ext.Date.patterns.ISO8601Long)]}</div>',
                    '</div>',
                    '<div class="thumb-download"></div>',
                '</a>',
            '</div>',
        '</tpl>'
    ]
});
