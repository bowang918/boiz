Ext.define('App.view.quarterly.QuarterlyChart',{
    extend: 'Ext.chart.CartesianChart',

    requires: ['Ext.chart.CartesianChart'],
    alias: 'widget.quarterlychart',

    cls: 'quarterly-chart',

    width: '100%',
    height: 400,
    insetPadding: '10px 20px 20px 40px',

    interactions: [{
        type: 'panzoom',
        zoomOnPanGesture: false,
        axes: {
            right: {
                maxZoom: 1
            }
        }
    }],

    animation: false,
    bind: '{stocks}',

    legend: { // null, false, undefined - doesn't work here. ??
        hidden: true
    },

    tbar: {
        defaults: {
            xtype: 'displayfield',
            labelAlign: 'top'
        },

        items: [{
            xtype: 'container',
            cls: 'stock-picker-wrapper',

            layout: {
                type: 'vbox'
            },

            padding: '0 0 0 15',

            items: [{
                xtype: 'cycle',
                cls: 'quarterly-cycle',
                showText: true,
                height: 40,
                text: 'AAPL',
                bind: {
                    text: '{stockMeta.symbol}'
                },
                textAlign: 'right',
                width: 135,

                listeners: {
                    change: 'menuItemClick'
                },

                menu: {
                    id: 'quarterly-menu',
                    items: [{
                        text: 'AAPL',
                        checked: true
                    }, {
                        text: 'GOOG'
                    }]
                }
            }, {
                xtype: 'displayfield',
                cls: 'stock-picker-small',
                textAlign: 'right',
                width: 105,
                bind: {
                    value: '{stockMeta.label}'
                }
            }]
        }, {
            text: '',
            width: 20
        }, {
            fieldLabel: 'CHANGE',
            bind: '{stockMeta.change}<span class="ql-percentage">({stockMeta.changePercentage}%)</span>',
            flex: 1
        }, {
            fieldLabel: 'PRICE',
            bind: '{stockMeta.price}',
            flex: 1
        }, {
            fieldLabel: 'MAX/MIN',
            bind: '{stockMeta.maxMin}',
            flex: 1
        }, {

            fieldLabel: 'VOLUME',
            bind: '{stockMeta.volume}',
            flex: 1
        }]
    },

    axes: [{
        type: 'numeric',
        position: 'right',
        fields: ['open', 'high', 'low', 'close'],
        grid: {
            lineDash: [2, 2],
            stroke: '#ccc'
        },
        style: {
            axisLine: false, //no axis
            majorTickSize: 0 //no ticks
        }
    }, {
        type: 'time',
        position: 'bottom',
        fields: ['time'],
        dateFormat: 'M y',
        segmenter: {
            type: 'time',
            step: {
                unit: Ext.Date.MONTH,
                step: 4
            }
        },

        grid: {
            lineDash: [2, 2],
            stroke: '#ccc'
        },
        style: {
            axisLine: false,
            majorTickSize: 0
        }
    }],

    series: [{
        type: 'candlestick',
        background: 'rgba(220,220,220,0.2)',
        xField: 'time',
        openField: 'open',
        highField: 'high',
        lowField: 'low',
        closeField: 'close',
        style: {
            barWidth: 5,
            dropStyle: {
                fill: '#22c6ef',
                stroke: '#22c6ef'
            },
            raiseStyle: {
                fill: '#f1495b',
                stroke: '#f1495b'
            }
        }
    }]
});
