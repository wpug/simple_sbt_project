## Uwagi na temat instalacji i konfiguracji SBT pod Windows

Pobieramy pakiet instalacyjny (MSI) *SBT* ze strony [www.scala-sbt.org](http://www.scala-sbt.org). Po jego zainstalowaniu powinniśmy zrobić jeszcze jedną rzecz, która pozwoli nam korzystać w naszych projektach domyślnie z kodowania `UTF-8`. Oczywiście uruchamiając SBT w linii poleceń musimy też zadbać, aby konsola również używała tego kodowania. Uzyskujemy to np. wykonując w niej polecenie `chcp 65001`.

Abt SBT również używało `UTF-8` musimy (jako administrator) otworzyć do edycji plik

    c:\Program Files (x86)\sbt\conf\sbtconfig.txt

i dodać do niego linijkę postaci:

    -Dfile.encoding=UTF8

Oczywiście również w projektach musimy wówczas używać kodowania `UTF-8`. Przykładowy szablon projektu opisany poniżej już to zapewnia.

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
                  │ - MainJoda.scala
                  │ - MainAkka.scala

Plik `build.sbt` zawiera definicję projektu (jega nazwę, numer wersji, wersje używanego kompilatora Scali) oraz
określa jego zależności. Plik `build.properties` może zawierać wiele różnych informacji, ale w naszym przypadku
znajduje się w nim jedynie informacja o uzywanej wersji narzędzia *SBT*. W pliku `plugins.sbt` umieszczona została
informacja o zainstalowanych/wykorzystywanych w ramach projektu _wtyczkach_ do *SBT*.

Znajdując się w katalogu projektu wydajemy polecenie

    sbt

które spowoduje uruchomienie środowiska *SBT*. O jego możliwościach poczytać można na stronie
[www.scala-sbt.org](http://www.scala-sbt.org). Między innymi pozwala ono na kompilowanie – polecenie `compile`
i uruchamianie skompilowanego projektu – polecenie `run`. Polecenia *SBT* moga byc poprzedzone znakiem `~`, co
spowoduje, że będą one uruchamiane automatycznie po dokonaniu zmian w plikach źródłowych.

Ponieważ programując z wykorzystaniem środowiska *Akka* będziemy często tworzyli kod, którego zadaniem będzie
„praca ciągła” więc wby nie tracić dostepu do linii poleceń *SBT* korzystać będziemy z wtyczki
[sbt-revolver](https://github.com/spray/sbt-revolver). O jej mozliwościach poczytac mozna na stronie projektu.
Najważniejsze dwa polecenia, to `re-start` i `re-stop` służące do uruchamiania oraz zatrzymywania projektu.
