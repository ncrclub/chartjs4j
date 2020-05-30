# chartjs4j

A Library for producing chartjs charts.


public enum Type {
    line("line")
    , bar("bar")
    , horizontalBar("horizontalBar")
    , radar("radar")
    , doughnut("doughnut")
    , pie("pie")
    , polarArea("polarArea")
    , bubble("bubble")
    , scatter("scatter");

                

```
String title = "Top Motors";
Type type = Type.horizontalBar;

Chart chart = new Chart(type, title)
  .addSeries("Flights", series, Color.SOFT_BLUE, Color.SOFT_BLUE)
  .withLedgend(legend -> 
      legend.setDisplay(true)
            .withFullWidth(true)
            .setPosition(Legend.Position.top))
  .withXAxes(0, x -> x.linear().setPosition("top"))
  .withYAxes(0, y -> y.setPosition("left"))
  ;
```



```
String title = "Flights by Classification";
Type type = Type.horizontalBar;
Chart chart = new Chart(type,title)
  .addSeries(type, "Class-1 (A,B,C,D,E,F,G)", class1, Color.ORANGE_SPECTRUM[0], Color.WHITE)
  .addSeries(type, "Class-2 (H,I,J,K,L)", class2, Color.ORANGE_SPECTRUM[1], Color.WHITE)
  .addSeries(type, "Class-3 (M,N,O,P,Q)", class3, Color.ORANGE_SPECTRUM[2], Color.WHITE)
  .withLedgend(legend -> 
      legend.setDisplay(true)
            .setPosition(Legend.Position.top))
  .withYAxes(0, y -> 
      y.stacked(stacked)
       .hidden()
       .withGridLines(g -> g.color(Color.WHITE)))
  .withXAxes(0, x -> 
      x.stacked(stacked)
       .hidden()
       .withGridLines(g -> g.color(Color.WHITE)))
  ;
```
                
