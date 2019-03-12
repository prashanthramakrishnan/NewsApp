NewsApp
=======

**Developed by:[Prashanth Ramakrishnan](prashanth_r03@yahoo.co.in)**
Powered by [https://newsapi.org/](url)


**Features**
- Uses NewsApi v2 endpoint. Fetches the articles via the top-headlines endpoint and shows the list in a recycler view. On clicking the list item a WebView is opened to load the original news article.
- Demonstrates how to fetch data by using the below mentioned libraries to unit test, instrument test the code and use the presenter pattern.
- Source is now configured to be only **The Hindu**. Can be changed with the buildConfig field present in the module build.gradle file.
- Use your own api key and insert it in the module build.gradle file for the API to work.
- API call is handled using Presenter pattern with unit testing.
- Instrumentation test is written using AndroidJUnitRunner and Robotium.

**Open source libaries used**
- **[Dagger2](https://github.com/google/dagger)**
- **[RxJava2](https://github.com/ReactiveX/RxJava)**
- **[RxAndroid](https://github.com/ReactiveX/RxAndroid)**
- **[Retrofit2](https://github.com/square/retrofit)**
- **[OkHttp3](https://github.com/square/okhttp)**
- **[Picasso](https://github.com/square/picasso)**
- **[Gson](https://github.com/google/gson)**
- **[Timber](https://github.com/JakeWharton/timber)**
- **[Project Lombok](https://projectlombok.org)**
- **[ButterKnife](https://github.com/JakeWharton/butterknife)**
- **[Robotium](https://github.com/RobotiumTech/robotium)**
- **[MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver)**

### License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.