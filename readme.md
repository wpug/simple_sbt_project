
## Prosty przykład projektu dla SBT

Repozytorium zawiera bardzo prosty przykład projektu przygotowanego do działania
z narzędziem *SBT*.

Aby sklonować zawartość repozytorium, należy wydać polecenie

    git clone https://github.com/wpug/simple_sbt_project.git

Po jego wykonaniu, w bieżącym katalogu pojawi się podkatalog o nazwie `simple_sbt_project`. Wewnątrz
znajduje się kilka katalogów i plików.

    │- build.sbt
    ├───project
    │     │ - build.properties
    │     │ - plugins.sbt
    │
    └───src
        └───main
            └───scala
                  │ - MainHello.scala
                  │ - MainJoda.scala

Plik `build.sbt` zawiera definicję projektu (jega nazwę, numer wersji, wersje używanego kompilatora Scali) oraz
określa jego zależności. Plik `build.properties` może zawierać wiele różnych informacji, ale w naszym przypadku
znajduje się w nim jedynie informacja o uzywanej wersji narzędzia *SBT*. W pliku `plugins.sbt` umieszczona została
informacja o zainstalowanych/wykorzystywanych w ramach projektu _wtyczkach_ do *SBT*.

Znajdując się w katalogu projektu wydajemy polecenie

    sbt

które spowoduje uruchomienie środowiska *SBT*. O jego możliwościach poczytać można na stronie
[www.scala-sbt.org](http://www.scala-sbt.org). Między innymi pozwala ono na kompilowanie – polecenie `compile` –
i uruchamianie – polecenie `run` – skompilowanego projektu. Polecenia *SBT* mogą być poprzedzane znakiem `~`, co
spowoduje, że będą one uruchamiane automatycznie po dokonaniu zmian w plikach źródłowych. Przykładowo:

    ~compile

spowoduje automatyczną rekompilację kodu projektu po pojawieniu się w nim zmian.

Niekiedy, zwłaszcza programując z wykorzystaniem środowiska *Akka*, zainsteresowani będziemy uruchamianiem
naszej aplikacji w osobnej instancji JVM. W szczególności pozwoli nam to nie tracić dostępu do linii poleceń
*SBT* w momencie, gdy aplikacja działa. Do obsługi takiego trybu uruchamiania aplikacji wykorzystamy wtyczkę
[sbt-revolver](https://github.com/spray/sbt-revolver). O jej możliwościach poczytać można na stronie projektu.
Wtyczka udostępnia dodatkowe trzy polecenia: `reStart`, `reStop` oraz `reStatus` pozwalające na uruchamianie, zatrzymywanie oraz badanie stanu wykonywania się projektu.

## Uwagi na temat instalacji i konfiguracji SBT pod Windows

Pobieramy pakiet instalacyjny (MSI) *SBT* ze strony [www.scala-sbt.org](http://www.scala-sbt.org). Po jego zainstalowaniu powinniśmy zrobić jeszcze jedną rzecz, która pozwoli nam korzystać w naszych projektach domyślnie z kodowania `UTF-8`. Uruchamiając SBT w linii poleceń musimy zadbać, aby konsola również używała tego kodowania. Uzyskujemy to np. wykonując w niej polecenie `chcp 65001`.

Oczywiście w plikach źródłowych projektu musimy wówczas również używać kodowania `UTF-8`. Przykładowy szablon projektu opisany powyżej już to zapewnia.
