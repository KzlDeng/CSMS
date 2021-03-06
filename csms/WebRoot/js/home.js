/** t图片滚动 */
window.onload = function() {
	var odiv = document.getElementById('div-img');
	var oul = odiv.getElementsByTagName('ul')[0];
	var ali = oul.getElementsByTagName('li');
	var spa = -2;
	oul.innerHTML = oul.innerHTML + oul.innerHTML;
	oul.style.width = ali[0].offsetWidth * ali.length + 'px';

	function move() {
		if (oul.offsetLeft < -oul.offsetWidth / 2) {
			oul.style.left = '0';
		}
		if (oul.offsetLeft > 0) {
			oul.style.left = -oul.offsetWidth / 2 + 'px'
		}
		oul.style.left = oul.offsetLeft + spa + 'px';
	}
	var timer = setInterval(move, 30)

}

/** layui模块调取 */
layui.use(['element', 'carousel', 'table'], function() {
	var element = layui.element;
	var carousel = layui.carousel;
	var table = layui.table;
	// 轮播
	carousel.render({
		elem : '#lb',
		width : '100%' // 设置容器宽度
		,
		height : 600,
		arrow : 'always' // 始终显示箭头
			// ,anim: 'updown' //切换动画方式
		});
	// 标题表格
	table.render({
				elem : '#table-title',
				height : 513,
				url : "getnew.action?newsId=" // 数据接口
				,
				page : false // 开启分页
				,
				cols : [[ // 表头
				{
					field : '',
					title : '',
					templet : function(d) {
						return "<a href='getnew.action?newsId=" + d.newid + "'>"
								+ d.newstitle + "</a>"
					}
				}]],
				done : function(res, curr, count) {
					$('#table-title').next().find('.layui-table-header').css({"display" : "none"});
					// $('th').hide();// 表头隐藏的样式
					// $('.layui-table .layui-table-cell >
					// span').css({'font-weight' : 'bold'});// 表头字体样式
					/*
					 * $('th').css({'background-color': '#5792c6', 'color':
					 * '#fff','font-weight':'bold'}) 表头的样式
					 * $('.layui-table-page').css('margin-top', '40px');//
					 * 页码部分的高度调整
					 */
				}

			})

	// 热点文章表格
	table.render({
				elem : '#table-forum',
				height :300,
				url : "getforum.action" // 数据接口
				,skin: 'line',
				page : false // 开启分页
				,
				cols : [[ // 表头
				{
					field : '',
					title : '文章标题',
					templet : function(d) {
						return "<a href='getcontent.action?op=byforumid&titleid="
								+ d.forumid + "'>" + d.title + "</a>"
					}
					
				},{
					field : '',
					title : '文章发布人',
					width:120,
					templet : function(d) {
						return "<a href='getcontent.action?op=byforumid&titleid="
								+ d.forumid + "'>" + d.author + "</a>"
					}
				},{
					field : '',
					title : '文章发布时间',
					templet : function(d) {
						return "<a href='getcontent.action?op=byforumid&titleid="
								+ d.forumid + "'>" + d.createtime + "</a>"
					}}
				]],
				done : function(res, curr, count) {
//					$('#table-forum').next().find('.layui-table-header').css({
//								"display" : "none"
//							});
					// $('th').hide();// 表头隐藏的样式
					// $('.layui-table .layui-table-cell >
					// span').css({'font-weight' : 'bold'});// 表头字体样式
					/*
					 * $('th').css({'background-color': '#5792c6', 'color':
					 * '#fff','font-weight':'bold'}) 表头的样式
					 * $('.layui-table-page').css('margin-top', '40px');//
					 * 页码部分的高度调整
					 */
				}

			})
	// 报名排行
	table.render({
				elem : '#table-score',
				height : 300,
				url : "getscore.action?op=getrank",
				page:false,
				limit:6,
				cols : [[{
				    	   align:'center',
							field : '',
							title : '排名',
							type:'numbers'
						},{
							align:'center',
							field : 'collegename',
							title : '学院名称'
						}, {
							align:'center',
							field : 'gold',
							title : '<i class="layui-icon layui-icon-diamond" style="color:gold"></i>金牌'
						}, {
							align:'center',
							field : 'silver',
							title : '<i class="layui-icon layui-icon-diamond" style="color:#A8A8A8"></i>银牌'
						}, {
							align:'center',
							field : 'bronze',
							title : '<i class="layui-icon layui-icon-diamond" style="color:#B87333"></i>铜牌'
						}]],
				done : function(res, curr, count) {
					res.data[0]
					var aaa = res;
					var index=1;
					$("[data-field='collegename']").prev().each(function () {
                        index++;
                        if ($(this).text() == '1') {
                            $('tr').eq(index).css("background-color","#F08080");
                        } else if ($(this).text() == '2') {
                            $('tr').eq(index).css("background-color","#FFA500");
                        } else if ($(this).text() == '3') {
                            $('tr').eq(index).css("background-color","#90EE90");
                        }
                    });
				}

			})

});