Ќаписать приложение, позвол€ющее добавл€ть нового пользовател€ и просматривать список существующих пользователей. —труктура таблицы (id, им€, пароль, дата).

¬ класс UserJDBCManager поместите все операции с базой данных. ∆елательно в методы этого класс передовать и возвращать объекты класса User

public int create(User user)
public List findAll()

 лассы задани€:
hw5.users.MainWindow
hw5.users.UserJDBCManager
hw5.users.User

*********************************

Ќаписать приложение выполн€ющее аутентификацию пользовател€ на основе учЄтной записи созданнной в предыдущем задании. ≈сли пользователь зарегистрирован, то выводим список зарегистрированных пользователей, если нет, выводим "Ќеправильный логин или пароль"

public int create(User user)
public List findAll()
public User readByNamePass(String login, String pass)

 лассы задани€:
hw5.auth.MainWindow
hw5.auth.UserJDBCManager
hw5.auth.User