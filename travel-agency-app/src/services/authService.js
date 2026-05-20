import api from './api.js'

function parseUserId(data) {
  const userId = Number(
    data?.userId
    ?? data?.id
    ?? data?.user?.id
  )

  return Number.isInteger(userId) && userId > 0 ? userId : null
}

export const authService = {
  async login(email, password) {
    const data = await api.post('/auth/login', {
      email,
      password,
    })

    const userId = parseUserId(data)

    if (!data?.success || !userId) {
      throw new Error(data?.message || 'Login did not return a valid user id.')
    }

    localStorage.setItem('auth_token', data.token)

    return {
      userId,
      userName: data.userName ?? data.user?.name,
      userEmail: data.userEmail ?? data.user?.email,
      token: data.token,
      response: data,
    }
  },
}