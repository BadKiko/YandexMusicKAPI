# Yandex Music API for Kotlin

> [!IMPORTANT]
> Библиотека ещё в разработке и не имеет полный функционал.

Это неофициальная библиотека для взаимодействия с API Яндекс.Музыки на языке Kotlin. 

## Использование
### Установка 

Для использования библиотеки вам  сперва необходимо добавить jitpack

> Для Groovy:

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

> Для Kotlin DSL:

```
repositories {
  ...
  maven(url="https://jitpack.io")
}
```

И добавить библиотеку в build.gradle dependency

[![](https://jitpack.io/v/BadKiko/YandexMusicKAPI.svg)](https://jitpack.io/#BadKiko/YandexMusicKAPI)

> Для Groovy:

```
implementation 'com.github.BadKiko:kige:version'
```

> Для Kotlin DSL:

```
implementation("com.github.BadKiko:kige:version")
```

### Получение токена

Большое количество способов уже расписано на сайте документации [yandex-music-api](https://yandex-music.readthedocs.io/en/main/token.html)
Но мне все способы не подошли ибо я работаю с часами, поэтому я разработал также библиотеку для взаимодействия с api oauth аутентификации через pair code (вам дают код на часах а вы его вводите с телефона тем самым входите в аккаунт Яндекс на часах), библиотека: [YandexRemoteAuthKAPI](https://github.com/BadKiko/YandexRemoteAuthKAPI)

### Использование 

Для начала вам необходимо создать YandexClient instance
```
val yandexClient =  YandexClient.create(token = "token")
```

#### Примеры дальнейшего использования 

```
val accountStatus = yandexClient.getStatus()

when(accountStatus){
    is StatusYandexMusicState.Error -> {
        // Если в итоге получения данных произошла ошибка, так же можно получить почему произошла ошибка accountStatus.message
    }
    is StatusYandexMusicState.Success -     > {
        // Если все ок и получили данные
        accountStatus.data
    }
}
```

## Используемые библиотеки

* [Retrofit](https://github.com/square/retrofit) - HTTP-клиент для Android и Java
* [SealedX](https://github.com/skydoves/sealedx) - утилитарная библиотека для работы с sealed классами
* [Sandwich](https://github.com/skydoves/sandwich) - утилитарная библиотека для работы с HTTP-ответами
* [Moshi](https://github.com/square/moshi) - библиотека для сериализации и десериализации JSON

Большое спасибо всем разработчикам, чьи библиотеки использовались в этом проекте, огромное спасибо всем разработчикам:
* [yandex-music-api](https://github.com/MarshalX/yandex-music-api)
