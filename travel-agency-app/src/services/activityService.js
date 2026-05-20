import api from './api.js'

// Maps airport codes and short city names to "City, Country" for display.
const DESTINATION_ALIASES = {
  'NEW YORK': 'New York, USA',
  JFK: 'New York, USA',
  LGA: 'New York, USA',
  EWR: 'New York, USA',
  'LOS ANGELES': 'Los Angeles, USA',
  LAX: 'Los Angeles, USA',
  'SAN FRANCISCO': 'San Francisco, USA',
  SFO: 'San Francisco, USA',
  PARIS: 'Paris, France',
  CDG: 'Paris, France',
  ORY: 'Paris, France',
  LONDON: 'London, UK',
  LHR: 'London, UK',
  LGW: 'London, UK',
  TOKYO: 'Tokyo, Japan',
  NRT: 'Tokyo, Japan',
  HND: 'Tokyo, Japan',
  HONOLULU: 'Honolulu, USA',
  HNL: 'Honolulu, USA',
  CHICAGO: 'Chicago, USA',
  ORD: 'Chicago, USA',
  MDW: 'Chicago, USA',
  MIAMI: 'Miami, USA',
  MIA: 'Miami, USA',
  SEATTLE: 'Seattle, USA',
  SEA: 'Seattle, USA',
  BOSTON: 'Boston, USA',
  BOS: 'Boston, USA',
  DUBAI: 'Dubai, UAE',
  DXB: 'Dubai, UAE',
  SINGAPORE: 'Singapore',
  SIN: 'Singapore',
  SYDNEY: 'Sydney, Australia',
  SYD: 'Sydney, Australia',
  SEOUL: 'Seoul, South Korea',
  ICN: 'Seoul, South Korea',
  BANGKOK: 'Bangkok, Thailand',
  BKK: 'Bangkok, Thailand',
  FRANKFURT: 'Frankfurt, Germany',
  FRA: 'Frankfurt, Germany',
  AMSTERDAM: 'Amsterdam, Netherlands',
  AMS: 'Amsterdam, Netherlands',
  TORONTO: 'Toronto, Canada',
  YYZ: 'Toronto, Canada',
  VANCOUVER: 'Vancouver, Canada',
  YVR: 'Vancouver, Canada',
  MADRID: 'Madrid, Spain',
  MAD: 'Madrid, Spain',
  ROME: 'Rome, Italy',
  FCO: 'Rome, Italy',
}

const COUNTRY_ALIASES = {
  USA: 'United States',
  US: 'United States',
  UK: 'United Kingdom',
  UAE: 'United Arab Emirates',
  KOREA: 'South Korea',
}

/**
 * Resolves a raw destination string (airport code, city, or "City, Country")
 * into { dest_name, country_name } ready for the backend query params.
 */
function getApiDestination(destination) {
  const raw = String(destination || '').trim().toUpperCase()

  // Strip parenthetical airport code: "Paris (CDG)" → "CDG"
  const parenMatch = raw.match(/\(([A-Z]{3})\)/)
  const code = parenMatch ? parenMatch[1] : (/^[A-Z]{3}$/.test(raw) ? raw : null)

  const normalized = (code && DESTINATION_ALIASES[code])
      ? DESTINATION_ALIASES[code]
      : (DESTINATION_ALIASES[raw] || String(destination || '').trim())

  const [cityPart, countryLabel] = normalized.split(',').map((p) => p?.trim())
  const countryUpper = (countryLabel || '').toUpperCase()
  const country_name = COUNTRY_ALIASES[countryUpper] || countryLabel || 'United States'

  return { dest_name: cityPart || normalized, country_name }
}

export const activityService = {
  /**
   * Searches activities via the Spring backend.
   * Returns an array of AttractionDTO objects shaped for ActivityList.vue:
   *   { id, name, category, icon, location, duration,
   *     pricePerPerson, totalPrice, maxGroupSize, rating, reviews, description }
   */
  async search({ destination, fromDate, toDate, adults, children }) {
    const { dest_name, country_name } = getApiDestination(destination)

    const activities = await api.get('/attractions/search', {
      params: {
        dest_name,
        country_name,
        start_date: fromDate,
        end_date: toDate,
        adults: adults ?? 1,
        children: children ?? 0,
      },
    })

    // `api` already unwraps response.data via its interceptor, so activities is the array.
    const list = Array.isArray(activities) ? activities : []

    if (list.length === 0) {
      throw new Error(`No activities found for "${dest_name}". Try a major city like Paris, Tokyo, or New York.`)
    }

    return list
  },
}