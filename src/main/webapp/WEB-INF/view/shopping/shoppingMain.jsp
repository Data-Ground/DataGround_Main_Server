<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<script src="https://d3js.org/d3.v3.min.js"></script>
    <script src="https://rawgit.com/jasondavies/d3-cloud/master/build/d3.layout.cloud.js" type="text/JavaScript"></script>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
</head>
<body>
	<jsp:include page="/WEB-INF/view/main.jsp" />
	<script>

    var skillsToDraw = [
	 { text: '패딩', size: 80 },
	 { text: '목도리', size: 30 },
	 { text: '롱패딩', size: 50 },
	 { text: '원피스', size: 50 },
	 { text: '겨울코트', size: 60 },
	 { text: '기모바지', size: 60 },
	 { text: '스웨터', size: 30 },
	 { text: '후드티', size: 20 },
	 { text: '맨투맨', size: 40 },
	 { text: '부츠', size: 40 },
	 { text: '패딩조끼', size: 50 },
	 { text: '귀도리', size: 76 }
	];

    var color = d3.scale.linear()
            .domain([0,1,2,3,4,5,6,10,15,20,100])
            .range(["#ffb3ba", "ffdfba", "#ffffba", "#baffc9", "#bae1ff", "#ffe0e7", "#d3f4ff", "#666", "#fef5dc", "#d2ffe1", "#e1e0ff", "#d6caf0"]);

    d3.layout.cloud().size([800, 300])
            .words(skillsToDraw)
            .rotate(function() {
            	 return ~~(Math.random() * 2) * 90;
            }) 
            .font("Impact")
            .fontSize(function(d) { return d.size; })
            .on("end", draw)
            .start();

    function draw(words) {
        d3.select("body").append("svg")
                .attr("width", 850)
                .attr("height", 350)
                .attr("class", "wordcloud")
                .append("g")
                // without the transform, words words would get cutoff to the left and top, they would
                // appear outside of the SVG area
                .attr("transform", "translate(320,200)")
                .selectAll("text")
                .data(words)
                .enter().append("text")                
 				.style("-webkit-touch-callout", "none") 				
				.style("-webkit-user-select", "none")
			 	.style("-khtml-user-select", "none")
				.style("-moz-user-select", "none") 
 				.style("-ms-user-select", "none")
 				.style("user-select", "none")
 				.style("cursor", "default")
                .style("font-size", function(d) { return d.size + "px"; })
                .style("fill", function(d, i) { return color(i,i,i); })
                .attr("transform", function(d) {
                    return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
                })
                .text(function(d) { return d.text; });
    }
    
    var margin = {top: 20, right: 20, bottom: 40, left: 20},
    width = 960 - margin.left - margin.right,
    height = 500 - margin.top - margin.bottom;

d3.csv("https://drive.google.com/file/d/1vArNfnTiZWw1GUwDw1i4yT_SHW-jgjee/view?usp=sharing", function(error, data) {

  var categories = d3.keys(d3.nest().key(function(d) { return d.category; }).map(data));
  var color = d3.scale.ordinal().range(["#66c2a5","#fc8d62","#8da0cb","#e78ac3","#a6d854"]);
  var fontSize = d3.scale.pow().exponent(5).domain([0,1]).range([10,80]);

  var layout = d3.layout.cloud()
      .timeInterval(10)
      .size([width, height])
      .words(data)
      .rotate(function(d) { return 0; })
      .font('monospace')
      .fontSize(function(d,i) { return fontSize(Math.random()); })
      .text(function(d) { return d.password; })
      .spiral("archimedean")
      .on("end", draw)
      .start();

  var svg = d3.select('body').append("svg")
      .attr("width", width + margin.left + margin.right)
      .attr("height", height + margin.top + margin.bottom)
    .append("g")
      .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

  var wordcloud = svg.append("g")
      .attr('class','wordcloud')
      .attr("transform", "translate(" + width/2 + "," + height/2 + ")");

  var x0 = d3.scale.ordinal()
      .rangeRoundBands([0, width], .1)
      .domain(categories);

  var xAxis = d3.svg.axis()
      .scale(x0)
      .orient("bottom");

  svg.append("g")
      .attr("class", "x axis")
      .attr("transform", "translate(0," + height + ")")
      .call(xAxis)
    .selectAll('text')
      .style('font-size','20px')
      .style('fill',function(d) { return color(d); })
      .style('font','sans-serif');

  function draw(words) {
    wordcloud.selectAll("text")
        .data(words)
      .enter().append("text")
        .attr('class','word')
        .style("font-size", function(d) { return d.size + "px"; })
        .style("font-family", function(d) { return d.font; })
        .style("fill", function(d) { 
            var paringObject = data.filter(function(obj) { return obj.password === d.text});
            return color(paringObject[0].category); 
        })
        .attr("text-anchor", "middle")
        .attr("transform", function(d) { return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")"; })
        .text(function(d) { return d.text; });
  };

});
</script>

<div style="width: 40%;">
    <div class="legend">
        Commonly used words are larger and slightly faded in color.  Less common words are smaller and darker.
    </div>

</div>
 	<div class = "row">
 		<div class = "col-lg-2">
	 		<div class="list-group">
			  <a href="#" class="list-group-item list-group-item-action active">
			    Cras justo odio
			  </a>
			  <a href="#" class="list-group-item list-group-item-action">Dapibus ac facilisis in
			  </a>
			  <a href="#" class="list-group-item list-group-item-action disabled">Morbi leo risus
			  </a>
			</div>
 		
 		</div>
		 <div class = "col-lg-4">
 		
 		
 		</div>
 		<div class = "col-lg-4">
 		
 		
 		</div>
 	</div>
 
</body>
</html>